package griffio.beans.configuration;

import griffio.beans.inject.SystemComponent;
import griffio.beans.inject.SystemUniqueId;
import griffio.beans.processor.Processor;
import griffio.beans.unique.UniqueType;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Provider;

@ContextConfiguration(classes = { ApplicationConfiguration.class })
@Test
public class ApplicationConfigurationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @SystemUniqueId(UniqueType.GUID)
    Processor<String> guidProcessor;

    @Autowired
    @SystemComponent(value = "dayOfWeekProcessor")
    Processor<Boolean> dayOfWeekProcessor;

    @Autowired
    @SystemComponent(value = "systemDate")
    Provider<LocalDate> systemDate;

    public void isDateDifferentInstance() {
        Assert.assertNotSame(systemDate.get(), systemDate.get());
    }

    public void isUniqueIdProcessor() {
        Assert.assertNotEquals(guidProcessor.execute(), guidProcessor.execute());
    }

    public void isDayOfWeekProcessor() {
        Assert.assertTrue(dayOfWeekProcessor.execute());
    }

}
