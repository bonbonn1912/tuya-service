package com.bonbonn.tuya.service.client;

import com.bonbonn.tuya.model.ApiRegulatorGet200Response;
import com.bonbonn.tuya.model.ElectricityMeter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/api")
public interface TuyaClient {

  @GetExchange("/regulator")
  ResponseEntity<ApiRegulatorGet200Response> getRegulatorInfo();

  @GetExchange("/electricity-meter")
  ResponseEntity<ElectricityMeter> getElectricityMeterInfo();


}
