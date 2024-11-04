package lotto.service.input.converter;

public class BallInputConverterService implements InputConverterService<Integer>{

    @Override
    public Integer convert(String input) {
        return Integer.parseInt(input);
    }
}
