package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;

public class LottoStore {

    public int calculateLottoCount(int inputMoney){
        return inputMoney / 1000;
    }

    public LottoTickets generateLottoTickets(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = generateLotto();
            lottoTickets.add(lotto);
        }
        return LottoTickets.from(lottoTickets);
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        lottoNumbers.sort(Comparator.naturalOrder());
        return new Lotto(lottoNumbers);
    }
}
