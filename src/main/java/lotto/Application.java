package lotto;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import lotto.domains.customer.Customer;
import lotto.domains.lotto.domain.LottoPrizeNumbers;
import lotto.domains.lotto.domain.LottoTicket;
import lotto.domains.lotto.domain.LottoTicketMachine;
import lotto.domains.lotto.type.LottoPrize;
import lotto.service.LottoResultFactory;
import lotto.service.LottoService;
import lotto.util.TypeConverter;
import lotto.view.InputInterface;
import lotto.view.OutputInterface;

public class Application {
	public static void main(String[] args) {
		InputInterface inputInterface = new InputInterface();
		LottoService lottoService = new LottoService();
		LottoResultFactory lottoResultFactory = new LottoResultFactory();

		Customer customer = purchaseLottoTickets(inputInterface);
		int ticketAmount = customer.calculateAmount();
		OutputInterface.printMessage(ticketAmount + OutputInterface.PURCHASE_AMOUNT.toString());

		LottoTicketMachine lottoTicketMachine = LottoTicketMachine.from(ticketAmount);

		LottoTicket lottoTickets = lottoTicketMachine.generateLottoTickets();
		OutputInterface.printMessage(lottoTickets.toString());
		OutputInterface.printNewLine();

		List<Integer> winningNumbers = drawWinningNumbers(inputInterface, lottoService);
		OutputInterface.printNewLine();

		int bonusNumber = drawBonusNumber(inputInterface, lottoService, winningNumbers);
		OutputInterface.printNewLine();

		LottoPrizeNumbers lottoPrizeNumbers = LottoPrizeNumbers.of(winningNumbers, bonusNumber);

		OutputInterface.printMessage(OutputInterface.WINNING_STATISTICS_INFORMATION);

		Map<LottoPrize, Integer> lottoResult = lottoResultFactory.generateLottoResult();
		List<Map<Integer, Boolean>> winningStatus = customer.checkWinningStatus(lottoTickets, lottoPrizeNumbers);

		String customerLottoResult = lottoTicketMachine.registerLottoResult(lottoResult, winningStatus);
		OutputInterface.printMessage(customerLottoResult);

		customer.calculateProfit(lottoResult);

		OutputInterface.printMessage(customer.formattingForPrintProfit());

	}

	private static Customer purchaseLottoTickets(InputInterface inputInterface) {
		while (true) {
			OutputInterface.printMessage(OutputInterface.ENTER_PURCHASE_PRICE);
			String price = inputInterface.readLine();
			try {
				OutputInterface.printNewLine();
				return Customer.from(TypeConverter.convertStringToInteger(price));
			} catch (NoSuchElementException | IllegalArgumentException exception) {
				processException(exception.getMessage());
			}
		}
	}

	private static List<Integer> drawWinningNumbers(InputInterface inputInterface, LottoService lottoService) {
		while (true) {
			OutputInterface.printMessage(OutputInterface.ENTER_WINNING_NUMBERS);
			String winningNumbers = inputInterface.readLine();
			try {
				return lottoService.drawWinningNumbers(winningNumbers.trim());
			} catch (NoSuchElementException | IllegalArgumentException exception) {
				processException(exception.getMessage());
			}
		}
	}

	private static int drawBonusNumber(InputInterface inputInterface, LottoService lottoService,
		List<Integer> winningNumbers) {
		while (true) {
			OutputInterface.printMessage(OutputInterface.ENTER_BONUS_NUMBER);
			String bonusNumber = inputInterface.readLine();
			try {
				return lottoService.drawBonusNumber(bonusNumber, winningNumbers);
			} catch (NoSuchElementException | IllegalArgumentException exception) {
				processException(exception.getMessage());
			}
		}
	}

	private static void processException(String message) {
		OutputInterface.printMessage(message);
	}
}
