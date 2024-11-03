package lotto.controller;

import java.util.List;

import lotto.model.LottoTicket;
import lotto.validator.InputValidator;
import lotto.validator.LottoTicketValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoPurchaseController {

	public List<LottoTicket> purchaseLottoTickets() {
		int purchasePrice = getValidatedPurchasePriceWithRetry();

		List<LottoTicket> tickets = LottoTicketGenerator.generateTickets(purchasePrice);
		int ticketsCount = tickets.size();
		OutputView.displayPurchaseCount(ticketsCount);
		OutputView.displayLottoTickets(tickets);

		return tickets;
	}

	private int getValidatedPurchasePriceWithRetry() {
		while (true) {
			String purchasePriceInput = InputView.inputPurchasePrice();
			try {
				return getValidatedPurchasePrice(purchasePriceInput);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public int getValidatedPurchasePrice(String purchasePriceInput) {
		int parsedPrice = InputValidator.validateInteger(purchasePriceInput);
		LottoTicketValidator.validatePurchasePrice(parsedPrice);
		return parsedPrice;
	}
}