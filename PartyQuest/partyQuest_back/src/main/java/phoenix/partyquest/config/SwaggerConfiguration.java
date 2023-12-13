package phoenix.partyquest.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("PartyQuest API 목록")
                .version("1.0")
                .description("PartyQuest에 사용된 API 목록입니다.");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
