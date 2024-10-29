package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public ArrayList<List<Integer>> generateLottoTickets(int lottoAmount) {
        ArrayList<List<Integer>> lottoTickets = new ArrayList<>();
        for(int lotto = 0; lotto < lottoAmount; lotto++) {
            List<Integer> lottoTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTickets.add(lottoTicket);
        }

        return lottoTickets;
    }
}
