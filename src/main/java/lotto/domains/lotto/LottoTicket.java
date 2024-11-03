package lotto.domains.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
	List<Lotto> tickets;

	public LottoTicket(List<Lotto> tickets) {
		this.tickets = new ArrayList<>(tickets);
	}

	@Override
	public String toString() {
		return tickets.stream()
			.map(Lotto::toString)
			.collect(Collectors.joining("\n"));
	}

	public List<Lotto> getTickets() {
		return new ArrayList<>(tickets);
	}
}
