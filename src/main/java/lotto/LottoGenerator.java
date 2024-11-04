package lotto;

import lotto.Random.RandomGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.enums.LottoConstants.*;


public class LottoGenerator {

    private RandomGenerator randomGenerator;

    public LottoGenerator(RandomGenerator randomGenerator) {

        this.randomGenerator = randomGenerator;
    }

    public List<Lotto> generateLottoBatch(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> generateLotto(getRandomNumber()))
                .toList();
    }

    public int getLottoBatchSize(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE.getValue();
    }

    private Lotto generateLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers.stream().sorted().toList());
    }

    public List<Integer> getRandomNumber() {
        return randomGenerator.getRandomNumber();
    }

    public void displayLottoBatch(List<Lotto> lottoBatch) {
        lottoBatch.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void displayLottoBatchSize(int purchaseAmount) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
    };
}
