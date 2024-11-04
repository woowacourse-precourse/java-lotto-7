package lotto.factory;

import java.util.List;
import java.util.stream.Stream;

import lotto.domain.Lotto;
import lotto.util.RandomNumberGenerator;

public class LottoTicketStore {

	private final RandomNumberGenerator randomNumberGenerator;

	public LottoTicketStore(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public Lotto createLottoTicket() {
		List<Integer> numbers = randomNumberGenerator.pickLottoNumbers();
		return new Lotto(numbers);
	}

	public List<Lotto> createLottoTickets(int buyCount) {
		return Stream.generate(this::createLottoTicket)
			.limit(buyCount)
			.toList();
	}
}
