package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.RandomNumberUtil;

public class TicketGenerator {

    public List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(generateLottoNumbers()));
        }
        return tickets;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(RandomNumberUtil.generateLottoNumber());
        Collections.sort(numbers);
        return numbers;
    }
}
