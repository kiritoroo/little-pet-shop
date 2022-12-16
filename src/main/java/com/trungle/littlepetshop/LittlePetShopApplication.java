package com.trungle.littlepetshop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@OpenAPIDefinition(
    info = @Info(
        title = "Little Pet Shop - API",
        version = "1.0",
        contact = @Contact(
            url = "https://github.com/kiritoroo/little-pet-shop",
            name = "Kiên Trung"
        )
    )
)
@SpringBootApplication
@EntityScan(basePackageClasses = LittlePetShopApplication.class)
public class LittlePetShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(LittlePetShopApplication.class, args);
    }

}
