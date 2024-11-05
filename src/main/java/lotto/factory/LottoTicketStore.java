package lotto.factory;

import java.util.List;
import java.util.stream.Stream;

import lotto.domain.Lotto;
import lotto.util.LottoNumberSorter;
import lotto.util.RandomNumberGenerator;

public class LottoTicketStore {

	private final RandomNumberGenerator randomNumberGenerator;
	private final LottoNumberSorter lottoNumberSorter;

	public LottoTicketStore(RandomNumberGenerator randomNumberGenerator, LottoNumberSorter lottoNumberSorter) {
		this.randomNumberGenerator = randomNumberGenerator;
		this.lottoNumberSorter = lottoNumberSorter;
	}

	public Lotto createLottoTicket() {
		List<Integer> numbers = randomNumberGenerator.pickLottoNumbers();
		lottoNumberSorter.sortInAscendingOrder(numbers);
		return new Lotto(numbers);
	}

	public List<Lotto> createLottoTickets(int buyCount) {
		return Stream.generate(this::createLottoTicket)
			.limit(buyCount)
			.toList();
	}
}
