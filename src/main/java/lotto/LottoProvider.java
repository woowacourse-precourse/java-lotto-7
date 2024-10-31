package lotto;

import java.util.List;
import java.util.stream.IntStream;
import lotto.global.ErrorMessage;

public class LottoProvider {
    private static final int MONEY_THRESHOLD = 1000;
    private final int trialCount;

    public LottoProvider(int money) {
        validate(money);
        this.trialCount = convertToCount(money);
    }

    private void validate(int money){
        if (money % MONEY_THRESHOLD != 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

    private int convertToCount(int money){
        return money / MONEY_THRESHOLD;
    }

    public List<Lotto> generateLottos(LottoGenerateStrategy lottoGenerateStrategy) {
        return IntStream.range(0, trialCount)
                .mapToObj(i -> generateSingleLotto(lottoGenerateStrategy))
                .toList();
    }

    private Lotto generateSingleLotto(LottoGenerateStrategy lottoGenerateStrategy) {
        List<Integer> numbers = lottoGenerateStrategy.pickNumbers();
        return new Lotto(numbers);
    }
}
