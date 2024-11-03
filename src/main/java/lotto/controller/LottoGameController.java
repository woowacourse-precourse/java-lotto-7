package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
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

        List<Integer> winningNum = getWinningNum();
        Lotto winningLotto = new Lotto(winningNum);

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

    private List<Integer> getWinningNum() {
        List<Integer> winningNum = new ArrayList<>();
        while (true) {
            try {
                String winningNumInput = inputView.getWinningNum();
                winningNum = winningNumValidator.validateWinningNum(winningNumInput);
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
                winningNumValidator.validateBonusNum(bonusNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNum;
    }
}
