package lotto.controller;

import java.util.List;

import lotto.domain.BonusNumber;
import lotto.domain.GameResults;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.common.Random;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

	private final LottoMachine lottoMachine;
	private final Random random;

	public LottoGame(LottoMachine lottoMachine, Random random) {
		this.lottoMachine = lottoMachine;
		this.random = random;
	}

	public void start(){
		Money money = new Money(InputView.readLottoPurchaseMoney());

		List<Lotto> lottos = lottoMachine.purchaseLottos(money, random);
		OutputView.printPurchaseLotto(lottos);

		WinningLotto winningLotto = new WinningLotto(InputView.readWinningNumbers());
		BonusNumber bonusNumber = new BonusNumber(InputView.readBonusNumber());

		GameResults gameResults = new GameResults(lottos, winningLotto, bonusNumber);

		OutputView.printGameResult(gameResults, lottos);
	}
}
