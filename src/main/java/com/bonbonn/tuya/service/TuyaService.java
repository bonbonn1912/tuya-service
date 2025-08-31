package com.bonbonn.tuya.service;

import com.bonbonn.tuya.model.ApiRegulatorGet200Response;
import com.bonbonn.tuya.model.ElectricityMeter;
import com.bonbonn.tuya.service.client.TuyaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TuyaService {

  private final TuyaClient tuyaClient;

  public ApiRegulatorGet200Response getElectricityMeterInfo(){
    return this.tuyaClient.getRegulatorInfo().getBody();
  }

  public ElectricityMeter getElectricityMeter(){
    return this.tuyaClient.getElectricityMeterInfo().getBody();
  }

}
