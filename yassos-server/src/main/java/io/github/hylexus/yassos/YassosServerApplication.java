package io.github.hylexus.yassos;

import io.github.hylexus.yassos.service.UserDetailService;
import io.github.hylexus.yassos.support.model.DefaultUserDetails;
import io.github.hylexus.yassos.support.props.YassosGlobalProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Random;

/**
 * @author hylexus
 * Created At 2019-06-07 16:38
 */
@SpringBootApplication
@EnableConfigurationProperties({YassosGlobalProps.class})
public class YassosServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YassosServerApplication.class, args);
    }

    @Bean
    public UserDetailService userDetailService() {
        return username -> new DefaultUserDetails()
                .setUsername(username)
                .setPassword("123456")
                .setUserId(new Random().nextLong())
                .setLocked(false)
                .setCredentialExpired(false)
                .setAvatarUrl("https://static.my-server.com/avatar/" + username + ".png");
    }

}
