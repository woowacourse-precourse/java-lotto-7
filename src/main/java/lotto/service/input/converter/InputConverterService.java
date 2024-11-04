package lotto.service.input.converter;

public interface InputConverterService<T> {
    T convert(String input);
}
