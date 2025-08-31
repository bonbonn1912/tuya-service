package com.bonbonn.tuya.service.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class TuyaClientConfig {

  @Value("${tuya.api-base-url}")
  private String tuyaBaseUrl;

  @Bean
  public TuyaClient tuyaClient() {
    RestClient restClient = RestClient.builder()
        .baseUrl(tuyaBaseUrl)
        .build();

    HttpServiceProxyFactory factory = HttpServiceProxyFactory
        .builderFor(RestClientAdapter.create(restClient))
        .build();

    return factory.createClient(TuyaClient.class);
  }
}
