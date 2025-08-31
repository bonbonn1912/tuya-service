package com.bonbonn.tuya.mock;

import com.bonbonn.tuya.model.ApiRegulatorGet200Response;
import com.bonbonn.tuya.model.ElectricityMeter;
import com.bonbonn.tuya.model.Regulator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock/api")
@Profile("mock-tuya")
public class MockController {


  @GetMapping("/electricity-meter")
  public ResponseEntity<ElectricityMeter> getElectricityMeter(){
    return ResponseEntity.ok(createElectricityMeterResponse());
  }

  @GetMapping("/regulator")
  public ResponseEntity<ApiRegulatorGet200Response> get200ResponseResponseEntity(){
    return ResponseEntity.ok(createMockRegulatorResponse());
  }


  public ApiRegulatorGet200Response createMockRegulatorResponse(){
    return new ApiRegulatorGet200Response()
        .regulatorLeda(getRegulator())
        .regulatorRoth(getRegulator());
  }

  public ElectricityMeter createElectricityMeterResponse(){
    return new ElectricityMeter().value(BigDecimal.valueOf(12345L))
        .lastUpdate(OffsetDateTime.now());
  }

  private Regulator getRegulator(){
    return new Regulator()
        .T1(BigDecimal.valueOf(100))
        .T2(BigDecimal.valueOf(200))
        .T3(BigDecimal.valueOf(50))
        .lastUpdate(OffsetDateTime.now());
  }
}
