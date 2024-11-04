package lotto.controller;

import lotto.model.LottoBundle;
import lotto.model.LottoCreator;
import lotto.model.Price;
import lotto.model.PurchasedLottoResultsDto;
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

	public LottoBundle run() {
		Price price = getPurchasePrice();
		return purchaseLotto(price);
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
		LottoBundle lottoBundle = new LottoBundle(price, lottoCreator);
		PurchasedLottoResultsDto purchasedLottoResultsDto = PurchasedLottoResultsDto.from(lottoBundle);
		outputView.printPurchasedLottoResultMessage(lottoBundle.getCount(), purchasedLottoResultsDto);
		return lottoBundle;
	}
}
