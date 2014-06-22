package griffio.beans.configuration;

import griffio.beans.inject.SystemComponent;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.inject.Provider;

/**
 * LocalDate is wrapped in Provider since LocalDate can't be proxied by @Lazy
 */
@Configuration
public class SystemDateConfiguration implements Provider<LocalDate> {

    @Override
    @Bean
    @Scope(value = "prototype")
    @SystemComponent(value = "systemDate")
    public LocalDate get() {
        return LocalDate.parse("2008-01-21");
    }
}
