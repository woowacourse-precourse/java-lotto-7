package lotto.domains.lotto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.util.LottoNumberGenerator;

public class LottoTicketMachine {
	private final int amount;

	public LottoTicketMachine(int amount) {
		this.amount = amount;
	}

	public LottoTickets generateLottoTickets(){
		return IntStream.range(0, amount)
			.mapToObj(i -> new Lotto(LottoNumberGenerator.generateLottoNumbers()))
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::new));
	}
}
