package lotto.domains.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
	List<Lotto> tickets;

	public LottoTickets(List<Lotto> tickets) {
		this.tickets = new ArrayList<>(tickets);
	}
}
