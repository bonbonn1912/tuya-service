package com.bonbonn.tuya.service;

import com.bonbonn.tuya.base.SafeExecutor;
import com.bonbonn.tuya.data.RegularElectricityMeter;
import com.bonbonn.tuya.data.entity.Queue;
import com.bonbonn.tuya.model.ApiRegulatorGet200Response;
import com.bonbonn.tuya.model.ElectricityMeter;
import com.bonbonn.tuya.service.client.TuyaClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class SchedulerService {
  private final QueueService queueService;
  private final TuyaClient tuyaClient;
  private final ObjectMapper objectMapper;
  private final DashboardService dashboardService;

  @Scheduled(fixedRate = 30000)
  public void fetchAndSend() {
    SafeExecutor.run(() -> {
      ApiRegulatorGet200Response response1 = this.tuyaClient.getRegulatorInfo().getBody();
      ElectricityMeter response2 = this.tuyaClient.getElectricityMeterInfo().getBody();

      RegularElectricityMeter mergedResponse = RegularElectricityMeter
          .builder()
          .regulatorResponse(response1)
          .electricityMeter(response2)
          .build();

      String payload = this.objectMapper.writeValueAsString(mergedResponse);
      log.info("Sending data: {}", payload);
      boolean success = this.dashboardService.sendData(mergedResponse);
      if (!success) {
        queueService.save(payload);
      }
      return null;
    });
  }

  @Scheduled(fixedRate = 5000)
  public void processQueue() {
    SafeExecutor.run(() -> {
      Queue entry = this.queueService.getNext();
      if (entry != null) {
        RegularElectricityMeter data = objectMapper.readValue(
            entry.getPayload(),
            RegularElectricityMeter.class
        );
        boolean success = this.dashboardService.sendData(data);
        if (success) {
          queueService.delete(entry.getId());
        }
      }
      return null;
    });
  }
}
