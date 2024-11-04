package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputLottoView {

  private static final String MESSAGE_PURCHASED_TICKETS = "%d개를 구매했습니다.";

  public static void printPurchasedTickets(List<Lotto> tickets) {
    System.out.println(String.format(MESSAGE_PURCHASED_TICKETS, tickets.size()));
    tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
  }
}
