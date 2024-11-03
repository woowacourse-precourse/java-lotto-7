package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import model.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> issueLottos(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().toList()));
        }
        return tickets;
    }
}
