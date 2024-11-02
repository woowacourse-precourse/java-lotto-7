package lotto.custom.model;

import static lotto.custom.constants.NumberConstants.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMaker {
    public Lottos run(int purchaseAmount) {
        int numberOfLottos = calculateNumberOfLottos(purchaseAmount);
        List<Lotto> lottos = generateLotto(numberOfLottos);
        return new Lottos(lottos);
    }

    private int calculateNumberOfLottos(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private List<Lotto> generateLotto(int numberOfLottos) {
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> generateLottoNumber())
                .collect(Collectors.toList());
    }

    private Lotto generateLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }
}