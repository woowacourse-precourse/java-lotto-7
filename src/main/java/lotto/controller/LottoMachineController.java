package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class LottoMachineController {
    public static List<Lotto> issueLotto(int lottoTicketNumber){
        List<Lotto> lottoTickets = new ArrayList<>();

        for(int i=0;i<lottoTicketNumber;i++){
            List<Integer> ticket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(ticket);
            // 겹치는지 확인
            lottoTickets.add(new Lotto(ticket));
        }

        return lottoTickets;
    }
}
