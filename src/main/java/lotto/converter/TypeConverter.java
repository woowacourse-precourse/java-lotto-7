package lotto.converter;

@FunctionalInterface
public interface TypeConverter<T, R> {

    R convert(T value);
}
