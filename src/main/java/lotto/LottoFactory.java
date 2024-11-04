package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoFactory {

    private final int RANDOM_START_NUMBER = 1;
    private final int RANDOM_END_NUMBER = 60;
    private final int LOTTO_LENGTH = 5;

    private RandomCreator randomCreator;
    private final LottoValidator lottoValidator;

    public LottoFactory() {
        this.randomCreator = new RandomCreator(RANDOM_START_NUMBER, RANDOM_END_NUMBER, LOTTO_LENGTH);
        this.lottoValidator = new LottoValidator();
    }

    public Lotto createLottoByNumbers(List<Integer> numbers) {
        lottoValidator.validateLottoCreate(numbers);
        return new Lotto(numbers);
    }

    public Lotto createLottoByRandom() {
        List<Integer> numbers = randomCreator.createRandomNumbers();
        return createLottoByNumbers(numbers);
    }
}
