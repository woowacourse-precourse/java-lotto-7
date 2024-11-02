package lotto;

import lotto.domains.customer.Customer;
import lotto.domains.lotto.LottoTicketMachine;
import lotto.domains.lotto.LottoTicket;
import lotto.service.CustomerFactory;
import lotto.service.LottoFactory;
import lotto.util.TypeConverter;
import lotto.view.InputInterface;
import lotto.view.OutputInterface;

public class Application {
	public static void main(String[] args) {
		InputInterface inputInterface = new InputInterface();
		LottoFactory lottoFactory = new LottoFactory();
		Customer customer = purchaseLottoTickets(inputInterface, new CustomerFactory());

		int ticketAmount = customer.calculateAmount();
		OutputInterface.printMessage(ticketAmount + OutputInterface.PURCHASE_AMOUNT.toString());

		LottoTicketMachine lottoTicketMachine = lottoFactory.generateLottoTicketMachine(ticketAmount);

		LottoTicket tickets = lottoFactory.generateLottoTicketMachine(lottoTicketMachine);
		OutputInterface.printMessage(tickets.toString());
		OutputInterface.printNewLine();

	}

	private static Customer purchaseLottoTickets(InputInterface inputInterface, CustomerFactory customerFactory) {
		while (true) {
			try {
				OutputInterface.printMessage(OutputInterface.ENTER_PURCHASE_PRICE);
				String price = inputInterface.readLine();
				OutputInterface.printNewLine();

				return customerFactory.generateCustomer(TypeConverter.convertStringToInteger(price));
			} catch (IllegalArgumentException exception){
				OutputInterface.printMessage(exception.getMessage());
				OutputInterface.printNewLine();
			}
		}
	}
}
