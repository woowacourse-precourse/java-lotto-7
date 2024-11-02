package lotto;

import lotto.domains.customer.Customer;
import lotto.domains.lotto.LottoTicket;
import lotto.domains.lotto.LottoTicketMachine;
import lotto.util.TypeConverter;
import lotto.view.InputInterface;
import lotto.view.OutputInterface;

public class Application {
	public static void main(String[] args) {
		InputInterface inputInterface = new InputInterface();
		Customer customer = purchaseLottoTickets(inputInterface);

		int ticketAmount = customer.calculateAmount();
		OutputInterface.printMessage(ticketAmount + OutputInterface.PURCHASE_AMOUNT.toString());

		LottoTicketMachine lottoTicketMachine = LottoTicketMachine.from(ticketAmount);

		LottoTicket tickets = lottoTicketMachine.generateLottoTickets();
		OutputInterface.printMessage(tickets.toString());
		OutputInterface.printNewLine();

		drawWinningNumbers(inputInterface, lottoTicketMachine);


	}

	private static void drawWinningNumbers(InputInterface inputInterface,
		LottoTicketMachine lottoTicketMachine) {
		while (true) {
			try {
				OutputInterface.printMessage(OutputInterface.ENTER_WINNING_NUMBERS);
				String winningNumbers = inputInterface.readLine();

				lottoTicketMachine.drawWinningNumbers(winningNumbers);
				break;
			} catch (IllegalArgumentException exception) {
				processException(exception);
			}
		}
	}

	private static Customer purchaseLottoTickets(InputInterface inputInterface) {
		while (true) {
			try {
				OutputInterface.printMessage(OutputInterface.ENTER_PURCHASE_PRICE);
				String price = inputInterface.readLine();
				OutputInterface.printNewLine();

				return Customer.from(TypeConverter.convertStringToInteger(price));
			} catch (IllegalArgumentException exception) {
				processException(exception);
			}
		}
	}

	private static void processException(IllegalArgumentException exception) {
		OutputInterface.printMessage(exception.getMessage());
		OutputInterface.printNewLine();
	}
}
