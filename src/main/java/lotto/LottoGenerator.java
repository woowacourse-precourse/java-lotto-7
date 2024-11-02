package lotto;

import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int LOTTO_COUNT = 6;

    private final RandomGenerator randomGenerator;

    public LottoGenerator() {
        this.randomGenerator = new RandomNumberGenerator();
    }

    public LottoGenerator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Lotto generateLotto() {
        return generateLotto(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_COUNT);
    }

    public Lotto generateLotto(int start, int end, int count) {
        List<Integer> numbers = randomGenerator.pickUniqueNumbersInRange(start, end, count);
        return new Lotto(numbers);
    }

}
