package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constant.DrawType;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Lottos;
import lotto.validator.PurchasePriceValidator;
import lotto.validator.WinningNumValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private LottoGame lottoGame;

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
        int purchasePrice = Integer.parseInt(getPurchasePrice());
        Lottos purchasedLottos = Lottos.randomFrom(purchasePrice / LOTTO_PRICE);
        outputView.showCreatedLottos(purchasedLottos.getLottos());

        List<Integer> winningNum = getWinningNum();
        Lotto winningLotto = new Lotto(winningNum);

        String bonusNum = getBonusNum();
        lottoGame = new LottoGame(purchasedLottos, winningLotto, Integer.parseInt(bonusNum));
        lottoGame.draw();
        Map<DrawType, Integer> drawTypeIntegerMap = lottoGame.generateDrawResult();
        long earns = lottoGame.calculateEarns(drawTypeIntegerMap, purchasePrice);
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
