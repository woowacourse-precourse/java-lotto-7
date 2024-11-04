package lotto.controller;

import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoPrize;
import lotto.model.domain.LottoWinningNumbers;
import lotto.model.domain.Pocket;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final LottoPrize lottoPrize;

    public LottoController() {
        this.lottoService = new LottoService();
        this.lottoPrize = new LottoPrize();
    }

    public void run() {
        Pocket pocket;
        Lotto winningLottoNumbers;
        BonusNumber bonusNumber;
        LottoWinningNumbers lottoWinningNumbers;

        while (true) {
            try {
                pocket = buyLottoWithMoney();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        while (true) {
            try {
                winningLottoNumbers = setWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        while (true) {
            try {
                bonusNumber = setWinningBonusNumber();
                lottoWinningNumbers = new LottoWinningNumbers(winningLottoNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }


        lottoService.calculateReward(lottoWinningNumbers, pocket, lottoPrize);

        OutputView.printRewardStatistic(lottoPrize.getRewardRankResult());

        OutputView.printProfitAtSecondDecimals(lottoPrize.getRewardPrizeResult(), pocket.getMoney());
    }

    private Pocket buyLottoWithMoney() {
        String inputMoney = InputView.requestMoney();
        int money = lottoService.moneyValidator(inputMoney);
        Pocket pocket = new Pocket(lottoService.activateLottoMachine(money),money);
        OutputView.printPurchasedLottoCount(pocket);
        return pocket;
    }

    private Lotto setWinningNumbers() {
        String inputWinningNumbers = InputView.requestLottoWinningNumbers();
        return lottoService.winningNumbersGenerator(inputWinningNumbers);
    }

    private BonusNumber setWinningBonusNumber() {
        String inputBonusNumber = InputView.requestLottoBonusNumber();
        return lottoService.bonusNumberGenerator(inputBonusNumber);
    }
}