package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.DrawType;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Lottos;
import lotto.model.dto.LottoGameResult;
import lotto.utils.ResultFormatter;
import lotto.validator.PurchasePriceValidator;
import lotto.validator.WinningNumValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final static int LOTTO_PRICE = 1000;

    private LottoGame lottoGame;

    private final InputView inputView;
    private final OutputView outputView;
    private final PurchasePriceValidator purchasePriceValidator;
    private final WinningNumValidator winningNumValidator;
    private final ResultFormatter resultFormatter;

    public LottoGameController(InputView inputView, OutputView outputView,
                               PurchasePriceValidator purchasePriceValidator, WinningNumValidator winningNumValidator,
                               ResultFormatter resultFormatter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchasePriceValidator = purchasePriceValidator;
        this.winningNumValidator = winningNumValidator;
        this.resultFormatter = resultFormatter;
    }

    public void run() {
        int purchasePrice = Integer.parseInt(getPurchasePrice());
        Lottos purchasedLottos = Lottos.randomFrom(purchasePrice / LOTTO_PRICE);
        outputView.showCreatedLottos(purchasedLottos.getLottos());

        Lotto winningLotto = createWinningLotto();

        createLottoGame(purchasedLottos, winningLotto);
        lottoGame.draw();

        Map<DrawType, Integer> drawResult = lottoGame.generateDrawResult();
        double earns = lottoGame.calculateEarns(drawResult, purchasePrice);

        Map<DrawType, Integer> formattedResult = resultFormatter.formatResult(drawResult);
        List<LottoGameResult> formattedFinalResult = resultFormatter.formatFinalResult(formattedResult);
        outputView.showDrawResults(formattedFinalResult, earns);
    }

    private String getPurchasePrice() {
        String purchasePrice;
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
        List<Integer> winningNum;
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

    private Lotto createWinningLotto() {
        Lotto winningLotto;
        while (true) {
            try {
                winningLotto = new Lotto(getWinningNum());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    private String getBonusNum() {
        String bonusNum;
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

    private void createLottoGame(Lottos purchasedLottos, Lotto winningLotto) {
        int bonusNum;
        while (true) {
            try {
                bonusNum = Integer.parseInt(getBonusNum());
                lottoGame = new LottoGame(purchasedLottos, winningLotto, bonusNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
