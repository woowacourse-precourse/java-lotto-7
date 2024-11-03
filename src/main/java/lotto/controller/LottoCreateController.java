package lotto.controller;

import java.util.List;

import lotto.model.LottoBundle;
import lotto.model.LottoCreator;
import lotto.model.Price;
import lotto.model.PurchaseLottoResultGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoCreateController {

	private final InputView inputView;
	private final OutputView outputView;
	private final LottoCreator lottoCreator;

	public LottoCreateController(InputView inputView, OutputView outputView, LottoCreator lottoCreator) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.lottoCreator = lottoCreator;
	}

	public void run() {
		Price price = getPurchasePrice();
		LottoBundle lottoBundle = purchaseLotto(price);
	}

	private Price getPurchasePrice() {
		try {
			outputView.printPurchasePriceInputMessage();
			int purchasePriceInput = inputView.getPurchasePriceInput();
			return new Price(purchasePriceInput);
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception.getMessage());
			return getPurchasePrice();
		}
	}

	private LottoBundle purchaseLotto(Price price) {
		LottoCreator lottoCreator = new LottoCreator();
		LottoBundle lottoBundle = new LottoBundle(price, lottoCreator);
		PurchaseLottoResultGenerator purchaseLottoResultGenerator = new PurchaseLottoResultGenerator();
		List<List<String>> purchaseLottoResult = purchaseLottoResultGenerator.generatePurchaseLottoResult(lottoBundle);
		outputView.printPurchaseLottoResultMessage(lottoBundle.getCount(), purchaseLottoResult);
		return lottoBundle;
	}
}
