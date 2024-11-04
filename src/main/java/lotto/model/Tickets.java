package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tickets {
    private static final int UNIT = 1000;

    private final int investAmount;
    private int ticketAmount;
    private final List<Lotto> tickets;

    public Tickets(int investAmount) {
        this.investAmount = investAmount;
        calculateTicketAmount();

        tickets = new ArrayList<>();
        generateTickets();
    }

    private void calculateTicketAmount() {
        ticketAmount = investAmount / UNIT;
    }

    private List<Integer> generateTicketNumbers() {
        List<Integer> ticketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        ticketNumbers = ticketNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
        return ticketNumbers;
    }

    private void generateTickets() {
        for (int i = 0; i < ticketAmount; i++) {
            List<Integer> ticketNumbers = generateTicketNumbers();

            tickets.add(new Lotto(ticketNumbers));
        }
    }

    public int getInvestAmount() {
        return investAmount;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}