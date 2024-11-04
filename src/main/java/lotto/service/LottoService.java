package lotto.service;

import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    public List<List<Integer>> generateLottoTickets(int ticketCount) {
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoCombination = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoCombination);
            Lotto lotto = new Lotto(lottoCombination);
            lottoTickets.add(lottoCombination);
        }
        return lottoTickets;
    }
}
