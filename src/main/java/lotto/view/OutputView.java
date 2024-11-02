package lotto.view;

import java.util.List;

import lotto.model.LottoTicket;

public class OutputView {
	private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";

	public static void displayPurchaseCount(int ticketCount) {
		System.out.println(ticketCount + TICKET_COUNT_MESSAGE);
	}

	public static void displayLottoTickets(List<LottoTicket> tickets) {
		for (LottoTicket ticket : tickets) {
			System.out.println(ticket.getNumbers());
		}
	}
}