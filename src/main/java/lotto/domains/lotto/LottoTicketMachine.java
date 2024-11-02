package lotto.domains.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.util.LottoNumberGenerator;

public class LottoTicketMachine {
	private final int amount;
	private List<Integer> winningNumbers;
	private int bonusNumber;
	private LottoTicketMachine(int amount) {
		this.amount = amount;
		this.winningNumbers = new ArrayList<>();
	}

	public static LottoTicketMachine from(int amount) {
		return new LottoTicketMachine(amount);
	}

	public LottoTicket generateLottoTickets(){
		return IntStream.range(0, amount)
			.mapToObj(i -> new Lotto(LottoNumberGenerator.generateLottoNumbers()))
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::new));
	}

	public void drawWinningNumbers() {

	}
}
