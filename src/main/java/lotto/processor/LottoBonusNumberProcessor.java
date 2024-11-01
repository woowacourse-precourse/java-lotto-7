package lotto.processor;

import lotto.converter.StringToIntegerConverter;
import lotto.converter.TypeConverter;
import lotto.domain.LottoBonusNumber;

public class LottoBonusNumberProcessor implements InputProcessor<LottoBonusNumber> {

    private final TypeConverter<String, Integer> converter;

    public LottoBonusNumberProcessor() {
        this.converter = new StringToIntegerConverter();
    }

    @Override
    public LottoBonusNumber process(String input) {
        return new LottoBonusNumber(converter.convert(input));
    }
}
