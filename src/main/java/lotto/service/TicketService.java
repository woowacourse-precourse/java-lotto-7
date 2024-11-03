package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Ticket;

public abstract class TicketService {
    public static Ticket generateTicket(int price, List<Integer> winningNumber, int bonusNumber) {
        int count = price / 1000;
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> LottoService.generateLotto())
                .toList();

        return new Ticket(lottos, price, winningNumber, bonusNumber);
    }
}
