package griffio.beans.processor;

import com.google.common.base.Supplier;
import org.joda.time.LocalDate;

import javax.inject.Provider;

/**
 * Processor is true when the date is the same day of the week
 */
public class DayOfWeekProcessor implements Processor<Boolean> {

    private final Provider<LocalDate> currentDate;
    private final Supplier<Integer> isoDayOfWeek;

    public DayOfWeekProcessor(Provider<LocalDate> currentDate, Supplier<Integer> isoDayOfWeek) {
        this.currentDate = currentDate;
        this.isoDayOfWeek = isoDayOfWeek;
    }

    public Boolean execute() {
        return currentDate.get().getDayOfWeek() == isoDayOfWeek.get();
    }

}
