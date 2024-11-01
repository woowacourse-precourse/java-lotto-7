package lotto.processor;

import lotto.converter.StringToIntegerListConverter;
import lotto.converter.TypeConverter;
import lotto.domain.Lotto;

import java.util.List;

public class LottoInputProcessor implements InputProcessor<Lotto> {

    private final TypeConverter<String, List<Integer>> converter;

    public LottoInputProcessor() {
        this.converter = new StringToIntegerListConverter();
    }

    @Override
    public Lotto process(String input) {
        return new Lotto(converter.convert(input));
    }
}
