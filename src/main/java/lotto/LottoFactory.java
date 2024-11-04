package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private final int RANDOM_START_NUMBER = 1;
    private final int RANDOM_END_NUMBER = 60;
    private final int LOTTO_LENGTH = 6;

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

    private Lotto createRandomLotto() {
        List<Integer> numbers = randomCreator.createRandomNumbers();
        return createLottoByNumbers(numbers);
    }

    public List<Lotto> createRandomLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            lottos.add(createRandomLotto());
        }
        return lottos;
    }
}
