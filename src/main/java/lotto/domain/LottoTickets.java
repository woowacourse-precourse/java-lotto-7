package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private List<Lotto> lottos;

    public LottoTickets(int purchaseAmount) {
        lottos = new ArrayList<>();
        generateLottoTickets(purchaseAmount);
    }

    private void generateLottoTickets(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
