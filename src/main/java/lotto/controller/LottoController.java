package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.InputValidator;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int PRICE_OF_LOTTO = 1000;

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGame lottoGame;

    public LottoController(InputView inputView, OutputView outputView, LottoGame lottoGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGame = lottoGame;
    }

    public void run() {
        // 1. 구입 금액 입력 및 로또 구매
        int purchaseNum = getPurchaseCount();
        lottoGame.buyLottos(purchaseNum);
        displayPurchasedLottos();

        // 2. 당첨 번호 및 보너스 번호 입력
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        // 3. 당첨 결과 및 수익률 계산
        lottoGame.calculateResults(winningNumbers, bonusNumber);
        displayResult();
        displayProfit(purchaseNum * PRICE_OF_LOTTO);
    }

    private int getPurchaseCount() {
        while (true) {
            try {
                String purchasePrice = inputView.inputPurchasePrice();
                InputValidator.validatePrice(purchasePrice);

                int purchaseNum = Integer.parseInt(purchasePrice) / PRICE_OF_LOTTO;
                outputView.showPurchaseCount(purchaseNum);

                return purchaseNum;
            } catch (IllegalArgumentException e) {
                outputView.showError(e.getMessage());
            }
        }
    }

    private void displayPurchasedLottos() {
        List<List<Integer>> purchasedLottos = lottoGame.getPurchasedLottos();
        for (List<Integer> numbers : purchasedLottos) {
            outputView.showLottoNumbers(numbers);
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String winningNumInput = inputView.inputWinningNumbers();
                InputValidator.validateWinningNum(winningNumInput);

                List<Integer> winningNum = Arrays.stream(winningNumInput.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();

                return new Lotto(winningNum).getNumbers();
            } catch (IllegalArgumentException e) {
                outputView.showError(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNum = inputView.inputBonusNumber();
                InputValidator.validateBonusNum(bonusNum);
                int bonusNumber = Integer.parseInt(bonusNum);

                InputValidator.validateBonusNumUnique(bonusNumber, winningNumbers);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.showError(e.getMessage());
            }
        }
    }

    private void displayResult() {
        outputView.showResultHeadline();
        for (Prize prize : Prize.values()) {
            outputView.showPrizeCount(prize.getDescription(), prize.getCount());
        }
    }

    private void displayProfit(int totalPrice) {
        double profit = lottoGame.calculateProfit(totalPrice);
        outputView.showProfit(profit);
    }
}