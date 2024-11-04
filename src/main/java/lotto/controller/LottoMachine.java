package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinLotto;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private InputView inputView;
    private OutputView outputView;

    public LottoMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void lottery() {
        PurchaseAmount purchaseAmount = initializePurchaseAmount();
        Lottos purchasedLottos = purchaseLottos(purchaseAmount);
        WinLotto winNumbers = initializeWinLotto();

    }

    private WinLotto initializeWinLotto() {
        Lotto winNumbers = initializeWinNumbers();
        while (true) {
            try {
                int bonusNumber = initializeBonusNumber();
                return new WinLotto(winNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int initializeBonusNumber() {
        final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

        String rawBonusNumber = inputView.readLine(BONUS_NUMBER_MESSAGE);

        return Parser.stringToInt(rawBonusNumber);
    }

    private Lotto initializeWinNumbers() {
        final String WIN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

        while (true) {
            try {
                String rawWinNumbers = inputView.readLine(WIN_NUMBERS_MESSAGE);
                List<Integer> winNumbers = Parser.splitNumbers(rawWinNumbers);

                return new Lotto(winNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos purchaseLottos(PurchaseAmount purchaseAmount) {
        Lottos lottos = new Lottos(purchaseAmount);
        outputView.printPurchaseLottos(lottos);

        return lottos;
    }

    private PurchaseAmount initializePurchaseAmount() {
        final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

        while (true) {
            try {
                String rawAmount = inputView.readLine(PURCHASE_AMOUNT_MESSAGE);
                long amount = Parser.stringToLong(rawAmount);

                return new PurchaseAmount(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
