package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.view.OutputView;

public class LottoMachineController {
    private final OutputView output = new OutputView();

    public List<Lotto> issueLotto(int lottoTicketNumber){
        List<Lotto> lottoTickets = new ArrayList<>();

        for(int i=0;i<lottoTicketNumber;i++){
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(ticket);
            output.printLottoTicket(ticket);
            lottoTickets.add(new Lotto(ticket));
        }

        return lottoTickets;
    }
}
