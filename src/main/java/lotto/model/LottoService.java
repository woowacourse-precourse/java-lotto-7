package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.enums.LottoRank;
import lotto.util.FormatString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private List<Lotto> lottos = new ArrayList<>();

    public LottoService() {}

    public List<Lotto> getLottos(int numOfTickets) {
        for (int i = 0; i < numOfTickets; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }

        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public List<LottoRank> getResult(List<Integer> winningNumbers, int bonusNumber) {
        List<LottoRank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatched = lotto.getNumbers().contains(bonusNumber);
            ranks.add(LottoRank.valueOf(matchCount, bonusMatched));
        }

        return ranks;
    }
}
