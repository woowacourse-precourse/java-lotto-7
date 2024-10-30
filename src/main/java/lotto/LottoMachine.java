package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public List<Lotto> issueLotto(int lottoTicketNumber){
        List<Lotto> lottoTickets = new ArrayList<>();

        for(int i=0;i<lottoTicketNumber;i++){
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(ticket);
            //발행한 로또 출력
            lottoTickets.add(new Lotto(ticket));
        }

        return lottoTickets;
    }
}
