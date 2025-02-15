package lotto.Controller;

import java.util.HashMap;
import java.util.Map;
import lotto.Domain.LottoGame;
import lotto.Enum.LottoWinningRank;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGameController {
    private static final String WINNING_NUMBER_KEY = "winningNumber";
    private static final String BONUS_NUMBER_KEY = "bonusNumber";

    private int lottoIssueCount;
    private String lottoPurchaseAmount;
    private String earningsRatio;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGame lottoGameService = new LottoGame();

    private final Map<String, String> lottoWinningNumberAndBonusNumberMap = new HashMap<>();

    public void playGame() {
        try {
            inputLottoPurchaseAmount();
            printPurchaseLottoCount();
            issueLottoNumbers();
            printIssuedLottoNumbers();
            setWinningNumberAndBonusNumber();
            decidePurchaseLottosRank();
            calculateEarningsRatio();
            printGameResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputLottoPurchaseAmount() {
        lottoPurchaseAmount = inputView.inputLottoPurchaseAmount();
    }

    public void printPurchaseLottoCount() {
        lottoIssueCount = lottoGameService.getLottoIssueCount(lottoPurchaseAmount);
        outputView.printPurchaseLottoCount(lottoIssueCount);
    }

    public void issueLottoNumbers() {
        for (int generateIndex = 0; generateIndex < lottoIssueCount; generateIndex++) {
            lottoGameService.addLottoNumberToLottoNumbers();
        }
    }

    public void printIssuedLottoNumbers() {
        outputView.printIssuedLottoNumbers(lottoGameService.getPurchaseLottoNumbers());
    }


    public void setWinningNumberAndBonusNumber() {
        String lottoWinningNumbers = inputView.inputLottoWinningNumbers();
        lottoGameService.validateLottoWinningNumbers(lottoWinningNumbers);
        String bonusNumber = inputView.inputLottoBonusNumber();
        lottoGameService.validateBonusNumber(lottoWinningNumbers, bonusNumber);
        lottoWinningNumberAndBonusNumberMap.put("winningNumber", lottoWinningNumbers);
        lottoWinningNumberAndBonusNumberMap.put("bonusNumber", bonusNumber);
    }

    public void decidePurchaseLottosRank() {
        String lottoWinningNumbers = lottoWinningNumberAndBonusNumberMap.get(WINNING_NUMBER_KEY);
        String bonusNumber = lottoWinningNumberAndBonusNumberMap.get(BONUS_NUMBER_KEY);
        for (int purchaseLottoIndex = 0; purchaseLottoIndex < lottoIssueCount; purchaseLottoIndex++) {
            LottoWinningRank lottoWinningRank =
                    lottoGameService.decideWinningRank(
                            lottoGameService.getPurchaseLottoNumbers().get(purchaseLottoIndex),
                            lottoWinningNumbers, bonusNumber);
            lottoGameService.updateWinningRankMap(lottoWinningRank);
        }
    }

    public void calculateEarningsRatio() {
        earningsRatio = lottoGameService.getEarningsRatio(lottoPurchaseAmount);
    }

    public void printGameResult() {
        outputView.printLottoWinningStatistics(lottoGameService.getLottoWinningRankMap());
        outputView.printEarningsRatio(earningsRatio);
    }
}