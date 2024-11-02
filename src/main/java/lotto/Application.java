package lotto;

import lotto.domains.customer.Customer;
import lotto.domains.lotto.LottoTicketMachine;
import lotto.domains.lotto.LottoTicket;
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



	}

	private static Customer purchaseLottoTickets(InputInterface inputInterface) {
		while (true) {
			try {
				OutputInterface.printMessage(OutputInterface.ENTER_PURCHASE_PRICE);
				String price = inputInterface.readLine();
				OutputInterface.printNewLine();

				return Customer.from(TypeConverter.convertStringToInteger(price));
			} catch (IllegalArgumentException exception){
				OutputInterface.printMessage(exception.getMessage());
				OutputInterface.printNewLine();
			}
		}
	}
}
