package lotto.domains.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.exception.ExceptionMessage;
import lotto.util.LottoNumberGenerator;
import lotto.util.Spliter;
import lotto.util.TypeConverter;

public class LottoTicketMachine {
	private static final String WINNING_NUMBER_REGEX = "^\\d+(,\\d+)*\\d$";
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

	public void drawWinningNumbers(String winningNumbers) {
		validateWinningNumberRegex(winningNumbers);
		saveWinningNumbers(winningNumbers);
	}

	private void saveWinningNumbers(String winningNumbers) {
		List<String> splittedWinningNumbers = Spliter.splitByComma(winningNumbers);
		this.winningNumbers = splittedWinningNumbers.stream()
			.map(TypeConverter::convertStringToInteger)
			.toList();
	}

	private void validateWinningNumberRegex(String winningNumbers) {
		if (Pattern.matches(winningNumbers, WINNING_NUMBER_REGEX)) {
			throw new IllegalArgumentException(ExceptionMessage.MISMATCHED_REGEX.toString());
		}
	}
}
