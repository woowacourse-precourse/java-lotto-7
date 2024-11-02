package lotto.converter;

public interface TypeConverter<T, R> {

    R convert(T value);
}
