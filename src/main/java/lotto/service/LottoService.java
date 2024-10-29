package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoService {

    public ArrayList<Lotto> generateLottoTickets(int lottoAmount) {
        ArrayList<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lottoTicket = new Lotto(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

}
