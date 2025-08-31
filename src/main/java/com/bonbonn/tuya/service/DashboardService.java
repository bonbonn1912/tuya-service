package com.bonbonn.tuya.service;

import com.bonbonn.tuya.data.RegularElectricityMeter;
import com.bonbonn.tuya.service.client.DashboardClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

  private final DashboardClient dashboardClient;

  public boolean sendData(RegularElectricityMeter data){
    try {
      this.dashboardClient.sendTuyaData(data);
      return true;
    } catch (Exception e){
      return false;
    }
  }

}
