package com.esprit.gestiontournoi;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.optionals.OptionalDecoder;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class FeignConfig {

    @Bean
    public Decoder feignDecoder() {
        return new ResponseEntityDecoder(new OptionalDecoder(new SpringDecoder(this::messageConverters)));
    }

    @Bean
    public Encoder feignEncoder() {
        return new SpringEncoder(this::messageConverters);
    }

    private HttpMessageConverters messageConverters() {
        MappingJackson2HttpMessageConverter halConverter = new MappingJackson2HttpMessageConverter();
        halConverter.getObjectMapper().registerModule(new Jackson2HalModule());
        return new HttpMessageConverters(halConverter);
    }

}
