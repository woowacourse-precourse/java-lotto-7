package lotto;

import lotto.domains.customer.Customer;
import lotto.domains.customer.CustomerFactory;
import lotto.domains.lotto.LottoTicketsFactory;
import lotto.util.TypeConverter;
import lotto.view.InputInterface;
import lotto.view.OutputInterface;

public class Application {
	public static void main(String[] args) {
		InputInterface inputInterface = new InputInterface();
		Customer customer = purchaseLottoTickets(inputInterface);
		int ticketCount = customer.calculateAmount();
		OutputInterface.printMessage(ticketCount + OutputInterface.PURCHASE_AMOUNT.toString());



	}

	private static Customer purchaseLottoTickets(InputInterface inputInterface) {
		while (true) {
			try {
				OutputInterface.printMessage(OutputInterface.ENTER_PURCHASE_PRICE);
				String price = inputInterface.readLine();
				OutputInterface.printNewLine();

				CustomerFactory factory = new CustomerFactory(){};
				return factory.generate(TypeConverter.convertStringToInteger(price));
			} catch (IllegalArgumentException exception){
				OutputInterface.printMessage(exception.getMessage());
				OutputInterface.printNewLine();
			}
		}
	}
}
