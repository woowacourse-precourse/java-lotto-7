package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoMachineController {
    public static List<Lotto> issueLotto(int lottoTicketNumber){
        List<Lotto> lottoTickets = new ArrayList<>();

        for(int i=0;i<lottoTicketNumber;i++){
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(ticket);
            lottoTickets.add(new Lotto(ticket));
        }

        return lottoTickets;
    }
}
