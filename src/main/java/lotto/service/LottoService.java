package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public List<Lotto> createLotto(int numberOfTickets) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    public List<Prize> calculatePrizes(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Prize> prizes = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.matchCount(lotto);
            boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());

            prizes.add(Prize.getPrize(matchCount, bonusMatch));
        }

        return prizes;
    }
}
