package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Ticket;
import lotto.util.Constants;

/**
 * 구매한 로또 번호 랜덤 생성기
 */
public class TicketRandomGenerator implements TicketGenerator {

    private long money;

    @Override
    public void setMoney(long money) {
        this.money = money;
    }

    @Override
    public List<Ticket> getTickets() {
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < getTicketCount(); i++) {
            tickets.add(getTicket());
        }

        return tickets;
    }

    @Override
    public Ticket getTicket() {
        List<Integer> numbers = new ArrayList<>(generateRandomNumbers());
        Collections.sort(numbers);
        return new Ticket(numbers);
    }

    private long getTicketCount() {
        return money / Constants.LOTTO_PRICE.getLong();
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                Constants.MIN_LOTTO_NUMBER.getNumber(),
                Constants.MAX_LOTTO_NUMBER.getNumber(),
                Constants.LOTTO_NUMBER_COUNT.getNumber());
    }
}
