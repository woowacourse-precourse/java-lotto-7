package lotto.util.input;

@FunctionalInterface
public interface SupplierWithException<T> {

    T get() throws IllegalArgumentException;
}
