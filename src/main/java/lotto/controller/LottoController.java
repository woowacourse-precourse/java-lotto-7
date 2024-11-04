package lotto.controller;

import static lotto.common.RequestMessage.*;

import java.util.List;

import lotto.data.LottoResult;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.utils.StringUtils;
import lotto.view.RequestView;
import lotto.view.ResponseView;

public class LottoController {

	private static final LottoController INSTANCE = new LottoController();

	private final RequestView requestView;
	private final ResponseView responseView;
	private final LottoService lottoService;

	private LottoController() {
		this.lottoService = LottoService.getInstance();
		this.requestView = RequestView.getInstance();
		this.responseView = ResponseView.getInstance();
	}

	public static LottoController getInstance() {
		return INSTANCE;
	}

	public void run() {
		int amount = StringUtils.toNumber(requestView.inputWithMessage(LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage()));
		List<Lotto> boughtLotto = lottoService.buy(amount);
		responseView.printBoughtLotto(boughtLotto);

		String winningNumbers = requestView.inputWithMessage(LOTTO_WINNING_NUMBERS_MESSAGE.getMessage());
		lottoService.saveWinningNumbers(winningNumbers);
		String bonusNumber = requestView.inputWithMessage(LOTTO_BONUS_NUMBER_MESSAGE.getMessage());
		lottoService.saveBonusNumber(bonusNumber);

		LottoResult lottoResult = lottoService.spinning();
		responseView.printResult(lottoResult, amount);
	}
}
