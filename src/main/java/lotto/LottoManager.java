package lotto;

import java.util.List;
import java.util.stream.IntStream;

import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.MainWinningNumbers;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningNumbers;
import lotto.io.IoHandler;
import lotto.random.RandomNumberGenerator;

public class LottoManager {
	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 45;
	private static final int NUMBER_SIZE = 6;

	private final IoHandler ioHandler;
	private final RandomNumberGenerator randomNumberGenerator;

	private LottoManager() {
		this.ioHandler = IoHandler.getInstance();
		this.randomNumberGenerator = RandomNumberGenerator.getInstance();
	}

	public static LottoManager create() {
		return new LottoManager();
	}

	public void run() {
		Amount amount = getAmount();
		PurchasedLottos purchasedLottos = purchaseLottoFrom(amount);
		ioHandler.showPurchaseLottos(purchasedLottos);

		WinningNumbers winningNumbers = creatWinningNumbers();
		LottoResult report = LottoResult.of(amount, purchasedLottos, winningNumbers);
		ioHandler.showLottoResult(report);
	}

	private Amount getAmount() {
		while (true) {
			int inputAmount = ioHandler.getPurchaseAmountFromUser();
			try {
				return Amount.of(inputAmount);
			} catch (IllegalArgumentException invalidAmount) {
				ioHandler.showExceptionMessage(invalidAmount.getMessage());
			}
		}
	}

	private PurchasedLottos purchaseLottoFrom(Amount amount) {
		int quantity = amount.getQuantity();
		List<Lotto> lottos = IntStream.range(0, quantity)
			.mapToObj(
				i -> new Lotto(
					randomNumberGenerator.generateSortedUniqueNumbers(START_NUMBER, END_NUMBER, NUMBER_SIZE)))
			.toList();
		return PurchasedLottos.from(lottos);
	}

	private WinningNumbers creatWinningNumbers() {
		MainWinningNumbers mainWinningNumbers = getMainWinningNumbers();
		return getBonusNumber(mainWinningNumbers);
	}

	private MainWinningNumbers getMainWinningNumbers() {
		while (true) {
			try {
				return MainWinningNumbers.from(ioHandler.getWinningNumbersFromUser());
			} catch (IllegalArgumentException invalidMainWinningNumbers) {
				ioHandler.showExceptionMessage(invalidMainWinningNumbers.getMessage());
			}
		}
	}

	private WinningNumbers getBonusNumber(MainWinningNumbers mainWinningNumbers) {
		while (true) {
			try {
				BonusNumber bonusNumber = BonusNumber.from(ioHandler.getBonusNumberFromUser());
				return WinningNumbers.of(mainWinningNumbers, bonusNumber);
			} catch (IllegalArgumentException invalidBonusNumber) {
				ioHandler.showExceptionMessage(invalidBonusNumber.getMessage());
			}
		}
	}
}
