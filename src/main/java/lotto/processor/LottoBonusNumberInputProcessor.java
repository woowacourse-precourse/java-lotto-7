package lotto.processor;

import lotto.converter.StringToIntegerConverter;
import lotto.converter.TypeConverter;
import lotto.domain.LottoBonusNumber;

public class LottoBonusNumberInputProcessor implements InputProcessor<LottoBonusNumber> {

    private final TypeConverter<String, Integer> converter;

    public LottoBonusNumberInputProcessor() {
        this.converter = new StringToIntegerConverter();
    }

    @Override
    public LottoBonusNumber process(String input) {
        return new LottoBonusNumber(converter.convert(input));
    }
}
