package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class LottoTicketGenerator {

    public Lotto generateLottoTicket() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, REQUIRED_LOTTO_NUMBERS));
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> generateMultipleLottoTickets(int lottoTicketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int ticketIndex = 0; ticketIndex < lottoTicketCount; ticketIndex++) {
            tickets.add(generateLottoTicket());
        }
        return tickets;
    }
}
