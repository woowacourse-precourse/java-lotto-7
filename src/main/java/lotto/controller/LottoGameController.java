package lotto.controller;

import lotto.model.Lottos;
import lotto.validator.PurchasePriceValidator;
import lotto.validator.WinningNumValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PurchasePriceValidator purchasePriceValidator;
    private final WinningNumValidator winningNumValidator;

    private final static int LOTTO_PRICE = 1000;

    public LottoGameController(InputView inputView, OutputView outputView,
                               PurchasePriceValidator purchasePriceValidator, WinningNumValidator winningNumValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchasePriceValidator = purchasePriceValidator;
        this.winningNumValidator = winningNumValidator;
    }

    public void run() {
        String purchasePrice = getPurchasePrice();
        Lottos lottos = Lottos.randomFrom(Integer.parseInt(purchasePrice) / LOTTO_PRICE);
        outputView.showCreatedLottos(lottos.getLottos());

        String winningNum = getWinningNum();
        String bonusNum = getBonusNum();
    }

    private String getPurchasePrice() {
        String purchasePrice = "";
        while (true) {
            try {
                purchasePrice = inputView.getPurchasePrice();
                purchasePriceValidator.validate(purchasePrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchasePrice;
    }

    private String getWinningNum() {
        String winningNum = "";
        while (true) {
            try {
                winningNum = inputView.getWinningNum();
                winningNumValidator.validate(winningNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNum;
    }

    private String getBonusNum() {
        String bonusNum = "";
        while (true) {
            try {
                bonusNum = inputView.getBonusNum();
                winningNumValidator.validate(bonusNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNum;
    }
}
