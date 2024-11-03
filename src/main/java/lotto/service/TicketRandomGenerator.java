package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Ticket;
import lotto.util.Constants;

public class TicketRandomGenerator implements TicketGenerator {

    private long money;

    public void setMoney(long money) {
        this.money = money;
    }

    public List<Ticket> getTickets() {
        List<Ticket> tickets = new ArrayList<>();

        long ticket_count = money / Constants.LOTTO_PRICE.getLong();

        for (int i = 0; i < ticket_count; i++) {
            tickets.add(getTicket());
        }

        return tickets;
    }

    public Ticket getTicket() {
        List<Integer> numbers = new ArrayList<>(generateRandomNumbers());
        Collections.sort(numbers);
        return new Ticket(numbers);
    }

    protected List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                Constants.MIN_LOTTO_NUMBER.getNumber(),
                Constants.MAX_LOTTO_NUMBER.getNumber(),
                Constants.LOTTO_NUMBER_COUNT.getNumber());
    }
}
