package com.bonbonn.tuya.data;

import com.bonbonn.tuya.model.ApiRegulatorGet200Response;
import com.bonbonn.tuya.model.ElectricityMeter;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegularElectricityMeter {

  ApiRegulatorGet200Response regulatorResponse;
  ElectricityMeter electricityMeter;

}
