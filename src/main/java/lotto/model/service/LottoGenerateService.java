package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottosDto;
import lotto.model.domain.Lotto;

public class LottoGenerateService {

    public LottosDto generateLottos(int amount) {
        int countOfGenerate = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < countOfGenerate; count++) {
            lottos.add(generateLotto());
        }
        return new LottosDto(lottos);
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER,
                Lotto.LOTTO_LENGTH));
    }
}
