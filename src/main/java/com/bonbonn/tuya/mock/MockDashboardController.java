package com.bonbonn.tuya.mock;

import com.bonbonn.tuya.data.RegularElectricityMeter;
import com.bonbonn.tuya.model.ElectricityMeter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock/api")
@Profile("mock-dashboard")
@Slf4j
public class MockDashboardController {

  @PostMapping("/tuya")
  public ResponseEntity<Void> getElectricityMeter(@RequestBody RegularElectricityMeter data){
    log.info("Received data on mocked dashboard controller{}", data);
    return ResponseEntity.ok().build();
  }

}
