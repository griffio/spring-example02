package griffio.beans.unique;

import com.google.common.base.Supplier;

import java.util.UUID;

public class GuidSupplier implements Supplier<String> {

    @Override
    public String get() {
        return UUID.randomUUID().toString();
    }
}
