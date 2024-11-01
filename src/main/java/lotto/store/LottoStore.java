package lotto.store;

import lotto.basic.NumbersGenerator;

import java.util.LinkedList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1_000;
    private static final int MINIMUM_MONEY = 0;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final NumbersGenerator numbersGenerator;

    public LottoStore(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public List<Lotto> sale(final int money) {
        if(isNotPositiveMoney(money))
            throw new IllegalArgumentException("돈은 양수만 가능합니다.");
        if(hasChange(money))
            throw new IllegalArgumentException("거스름돈이 발생합니다.");

        List<Lotto> result = new LinkedList<>();

        // TODO: lottoCount -> 좀 더 좋은 이름 ?
        int lottoCount = money / LOTTO_PRICE;
        for (int i = 0; i < lottoCount ; i++) {
            result.add(new Lotto(generateLottoNumbers()));
        }

        return result;
    }

    private List<Integer> generateLottoNumbers() {
        return numbersGenerator.random(
                MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE
        );
    }

    private boolean isNotPositiveMoney(int money) {
        return money <= MINIMUM_MONEY;
    }

    private static boolean hasChange(int money) {
        return money % LOTTO_PRICE != 0;
    }
}
