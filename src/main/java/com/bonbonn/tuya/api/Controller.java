package com.bonbonn.tuya.api;

import com.bonbonn.tuya.data.RegularElectricityMeter;
import com.bonbonn.tuya.service.TuyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

  private final TuyaService tuyaService;

  @RequestMapping("/sensor")
  public ResponseEntity<RegularElectricityMeter> getLatestSensorData(){
    return ResponseEntity.ok()
        .body(RegularElectricityMeter
            .builder()
            .electricityMeter(this.tuyaService.getElectricityMeter())
            .regulatorResponse(this.tuyaService.getElectricityMeterInfo())
            .build());
  }

}
