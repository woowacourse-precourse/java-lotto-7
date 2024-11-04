package lotto.service;

import static lotto.constants.LottoConstantNumbers.*;

import java.util.List;

import lotto.domain.Lotto;
import lotto.factory.LottoTicketStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoPurchaseService {

	private final InputView inputView;
	private final OutputView outputView;
	private final LottoTicketStore lottoTicketStore;

	public LottoPurchaseService(InputView inputView, OutputView outputView, LottoTicketStore lottoTicketStore) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.lottoTicketStore = lottoTicketStore;
	}

	public int purchaseForLottos() {
		return inputView.getPurchaseAmount();
	}

	public List<Lotto> buyLottos(int purchaseAmount) {
		int purchaseCount = purchaseAmount / LOTTO_PRICE.getValue();

		outputView.printPurchaseCountMessage(purchaseCount);
		List<Lotto> lottos = lottoTicketStore.createLottoTickets(purchaseCount);
		outputView.printLottoList(lottos);

		return lottos;
	}
}
