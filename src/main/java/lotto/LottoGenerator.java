package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Random.RandomGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.enums.LottoConstants.*;


public class LottoGenerator {

    private RandomGenerator randomGenerator;

    public LottoGenerator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public List<Lotto> generateLottoTicketBatch(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> generateLotto(getRandomNumber()))
                .toList();
    }

    public int getLottoBatchSize(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE.getValue();
    }

    private Lotto generateLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<Integer> getRandomNumber() {
        return randomGenerator.getRandomNumber();

    }
}
