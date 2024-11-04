package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;

public class LottoService {

    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int SIZE_OF_DEFAULT_NUMBERS = 6;

    public List<Lotto> buyLottos(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, lottoAmount)
            .forEach(i -> {
                Lotto lotto = new Lotto(generateLottoNumbers());
                lottos.add(lotto);
            });
        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> generatedNumber = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, SIZE_OF_DEFAULT_NUMBERS);
        return generatedNumber.stream().sorted().toList();
    }
}
