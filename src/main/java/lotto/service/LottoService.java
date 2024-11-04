package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    public List<Lotto> getLotto (int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < (purchaseAmount / 1000); i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
