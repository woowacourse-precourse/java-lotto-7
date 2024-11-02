package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final LottoMachine lottoMachine = new LottoMachine();
    private List<LottoTicket> userTickets;

    public void start() {
        int amount = inputAmount();
        int ticketCount = lottoMachine.calculateTicketCount(amount);

        userTickets = generateTickets(ticketCount);
        printTickets(usterTickets);
    }

    private int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int amount = Integer.parseInt(input);
            lottoMachine.vaildateAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자로 입력 하세요.");
            return inputAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }

    private List<LottoTicket> getUserTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            tickets.add(lottoMachine.generateTicket());
        }
        return tickets;
    }

    private void printTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        tickets.forEach(ticket -> System.out.println(ticket.getSortedNumbers()));
    }
}
