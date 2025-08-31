package com.bonbonn.tuya.service.client;

import com.bonbonn.tuya.data.RegularElectricityMeter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/api/tuya")
public interface DashboardClient {

  @PostExchange
  void sendTuyaData(@RequestBody RegularElectricityMeter data);

}
