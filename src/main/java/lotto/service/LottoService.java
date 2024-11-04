package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;

public class LottoService {

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
        List<Integer> generatedNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return generatedNumber.stream().sorted().toList();
    }
}
