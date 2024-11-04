package lotto.service.input.converter;

public class MoneyInputConverterService implements InputConverterService<Long> {
    @Override
    public Long convert(String input) {
        return Long.parseLong(input);
    }
}

