package service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import model.Lotto;
import validator.LottoBuyValidator;
import validator.LottoValidator;

public class LottoService {

    private static final LottoValidator LOTTO_VALIDATOR = new LottoValidator();
    private static final LottoBuyValidator LOTTO_BUY_VALIDATOR = new LottoBuyValidator();

    public LottoService() {
    }

    public Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public Lotto createRandomly() {
        List<Integer> numbers = pickUniqueNumbersInRange(
                Lotto.MIN_NUMBER,
                Lotto.MAX_NUMBER,
                Lotto.NUMBER_SIZE
        );

        return new Lotto(numbers);
    }

    public List<Lotto> buy(int moneyAmount) {
        LOTTO_BUY_VALIDATOR.validateMoneyAmount(moneyAmount);

        int lottoAmount = moneyAmount / Lotto.PRICE;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(createRandomly());
        }

        return lottos;
    }

    public void validateNumbers(List<Integer> numbers) {
        LOTTO_VALIDATOR.validateNumbers(numbers);
    }
}
