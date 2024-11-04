package lotto.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.DrawType;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Lottos;
import lotto.model.dto.LottoGameResult;
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

        Lotto winningLotto = createWinningLotto();

        createLottoGame(purchasedLottos, winningLotto);
        lottoGame.draw();

        Map<DrawType, Integer> drawResult = lottoGame.generateDrawResult();
        double earns = lottoGame.calculateEarns(drawResult, purchasePrice);
        showDrawResults(drawResult, earns);
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

    private void showDrawResults(Map<DrawType, Integer> drawResult, double earns) {
        List<LottoGameResult> result = new ArrayList<>();

        Map<DrawType, Integer> formattedFinalResult = formatFinalResult(drawResult);

        for (Map.Entry<DrawType, Integer> entry : formattedFinalResult.entrySet()) {
            DrawType drawType = entry.getKey();
            int matchNum = getMatchNum(drawType);
            int matchPrize = drawType.getPrize();
            int matchCount = entry.getValue();
            result.add(new LottoGameResult(matchNum, matchPrize, matchCount));
        }

        outputView.showDrawResults(result, earns);
    }

    private Map<DrawType, Integer> formatFinalResult(Map<DrawType, Integer> drawResult) {
        List<Map.Entry<DrawType, Integer>> entryList = new ArrayList<>(drawResult.entrySet());

        entryList.sort(Comparator.comparingInt(entry -> getMatchNum(entry.getKey())));
        if (!entryList.isEmpty()) {
            entryList.remove(entryList.getFirst());
        }

        Map<DrawType, Integer> formattedResult = new LinkedHashMap<>();
        for (Map.Entry<DrawType, Integer> entry : entryList) {
            formattedResult.put(entry.getKey(), entry.getValue());
        }

        return formattedResult;
    }

    private int getMatchNum(DrawType drawType) {
        int matchNum;
        try {
            matchNum = Integer.parseInt(drawType.getValue());
        } catch (NumberFormatException e) {
            matchNum = 5;
        }
        return matchNum;
    }
}
