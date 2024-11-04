package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoBuyer lottoBuyer;

    public LottoController() {
        LottoMachine lottoMachine = new LottoMachine(new LottoGenerator());
        this.lottoBuyer = new LottoBuyer(lottoMachine);
    }

    public void run() {
        Money purchaseAmount = inputPurchaseAmount();
        Lottos lottos = lottoBuyer.buyLottos(purchaseAmount);
        OutputView.printLottos(lottos);

        WinningLotto winningLotto = createWinningLotto();
        RankResult rankResult = lottoBuyer.checkWinning(winningLotto);

        OutputView.printWinningMatchCount(rankResult);
        OutputView.printRateOfEarning(rankResult.calculateRateOfResult(purchaseAmount));
    }

    private Money inputPurchaseAmount() {
        while (true) {
            try {
                return InputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private String inputWinningNumber() {
        while (true) {
            try {
                return InputView.inputWinningNumber();
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private BonusNumber inputBonusNumber() {
        while (true) {
            try {
                return InputView.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private WinningLotto createWinningLotto() {
        Lotto lotto;
        BonusNumber bonusNumber;
        while (true) {
            try {
                String winningNumber = inputWinningNumber();
                lotto = LottoGenerator.generate(winningNumber);
                bonusNumber = inputBonusNumber();
                validateBonusNumber(lotto, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }

        return new WinningLotto(lotto, bonusNumber);
    }

    private void validateBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 입력한 당첨번호와 중복돨 수 없습니다.");
        }
    }
}
