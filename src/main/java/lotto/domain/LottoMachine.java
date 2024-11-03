package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;

    public List<LottoTicket> publishTickets(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoTicket(generateLottoNumbers()));
        }
        return tickets;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
