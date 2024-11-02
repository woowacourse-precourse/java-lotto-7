package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class LottoMachineController {
    public static List<Lotto> issueLotto(int lottoTicketNumber) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int current = 0;
        while (current < lottoTicketNumber) {
            List<Integer> ticket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(ticket);
            Lotto newLotto = new Lotto(ticket);

            if (!lottoTickets.contains(newLotto)) {
                lottoTickets.add(newLotto);
                current++;
            }
        }
        return lottoTickets;
    }
}
