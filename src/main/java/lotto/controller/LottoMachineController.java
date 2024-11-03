package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class LottoMachineController {
    public static List<Lotto> issueLotto(int lottoTicketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int currentCount = 0;
        while (currentCount < lottoTicketCount) {
            List<Integer> ticket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(ticket);
            Lotto newLotto = new Lotto(ticket);

            if (!lottoTickets.contains(newLotto)) {
                lottoTickets.add(newLotto);
                currentCount++;
            }
        }
        return lottoTickets;
    }
}
