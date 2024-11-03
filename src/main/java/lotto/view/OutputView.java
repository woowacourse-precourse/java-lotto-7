package lotto.view;

import java.util.List;
import java.util.Map;

import lotto.model.LottoRank;
import lotto.model.LottoTicket;

public class OutputView {
	private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
	private static final String STATISTICS_HEADER = "당첨 통계\n---";

	public static void displayPurchaseCount(int ticketCount) {
		System.out.println(ticketCount + TICKET_COUNT_MESSAGE);
	}

	public static void displayLottoTickets(List<LottoTicket> tickets) {
		for (LottoTicket ticket : tickets) {
			System.out.println(ticket.getNumbers());
		}
	}

	public static void displayResult(Map<LottoRank, Integer> resultCount) {
		System.out.println(STATISTICS_HEADER);
		for (LottoRank rank : LottoRank.values()) {
			int count = resultCount.getOrDefault(rank, 0);
			System.out.printf("%s - %d개%n", rank.getDescription(), count);
		}
	}

	public static void displayTotalPrize(int totalPrize) {
		System.out.printf("총 상금: %,d원%n", totalPrize);
	}
}