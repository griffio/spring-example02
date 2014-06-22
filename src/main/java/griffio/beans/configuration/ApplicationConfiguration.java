package griffio.beans.configuration;

import griffio.beans.day.DaySupplier;
import griffio.beans.inject.SystemComponent;
import griffio.beans.inject.SystemUniqueId;
import griffio.beans.processor.DayOfWeekProcessor;
import griffio.beans.processor.Processor;
import griffio.beans.processor.UniqueProcessor;
import griffio.beans.unique.GuidSupplier;
import griffio.beans.unique.RandomSupplier;
import griffio.beans.unique.SequenceSupplier;
import griffio.beans.unique.UniqueType;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.inject.Provider;

@Configuration
@Import(SystemDateConfiguration.class)
public class ApplicationConfiguration {

    @Autowired
    @SystemComponent(value = "systemDate")
    Provider<LocalDate> systemDate;

    @Bean
    @SystemUniqueId(UniqueType.GUID)
    public Processor<String> guidProcessor() {
        return new UniqueProcessor(new GuidSupplier());
    }

    @Bean
    @SystemUniqueId(UniqueType.SEQUENCE)
    public Processor<String> sequenceProcessor() {
        return new UniqueProcessor(new SequenceSupplier());
    }

    @Bean
    @SystemUniqueId(UniqueType.RANDOM)
    public Processor<String> RandomProcessor() {
        return new UniqueProcessor(new RandomSupplier());
    }

    @Bean
    @SystemComponent(value = "dayOfWeekProcessor")
    public Processor<Boolean> dayOfWeekProcessor() {
        return new DayOfWeekProcessor(systemDate, new DaySupplier());
    }

}
