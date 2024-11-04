package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generateLottos(int totalTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < totalTickets; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, LottoConstants.LOTTO_SIZE));
    }
}