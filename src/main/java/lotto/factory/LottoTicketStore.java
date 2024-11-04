package lotto.factory;

import java.util.List;

import lotto.domain.Lotto;

public class LottoTicketStore {

	public Lotto createLottoTicket(List<Integer> numbers) {
		return new Lotto(numbers);
	}
}
