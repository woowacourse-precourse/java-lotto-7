package lotto;

import lotto.enums.LottoConfig;
import lotto.exception.LottoExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final NumberGenerator numberGenerator;

    public LottoGenerator() {
        this.numberGenerator = new NumberGenerator();
    }

    public Lotto generate() {
        int start = LottoConfig.LOTTO_START_NUM.getValue();
        int end = LottoConfig.LOTTO_END_NUM.getValue();
        int count = LottoConfig.LOTTO_NUM_LENGTH.getValue();

        return new Lotto(numberGenerator.generateUniqueNumber(start, end, count));
    }

    public Lotto generate(List<Integer> numbers){
        return new Lotto(numbers);
    }

    public List<Lotto> generate(int givenMoney) {
        List<Lotto> lottos = new ArrayList<>();
        int price = LottoConfig.LOTTO_PRICE.getValue();
        int count = givenMoney / price;

        validate(givenMoney);

        for (int i = 0; i < count; i++) {
            lottos.add(generate());
        }

        return lottos;
    }

    private void validate(int givenMoney) {
        if (givenMoney % LottoConfig.LOTTO_PRICE.getValue() != 0 || givenMoney ==0) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASING_MONEY_LASTED.getMessage());
        }
    }
}
