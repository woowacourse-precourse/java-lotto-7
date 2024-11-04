package lotto.processor;

import lotto.converter.StringToLongConverter;
import lotto.converter.TypeConverter;
import lotto.domain.LottoPurchaseMoney;

public class LottoPurchaseMoneyInputProcessor implements InputProcessor<LottoPurchaseMoney> {

    private final TypeConverter<String, Long> converter;

    public LottoPurchaseMoneyInputProcessor() {
        this.converter = new StringToLongConverter();
    }

    @Override
    public LottoPurchaseMoney process(String input) {
        return new LottoPurchaseMoney(converter.convert(input));
    }
}
