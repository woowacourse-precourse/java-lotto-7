package lotto.controller;

import lotto.model.*;
import lotto.util.InputValidator;
import lotto.view.UserInputView;
import lotto.view.UserOutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameController {

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = purchaseLottos(purchaseAmount);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Map<Rank, Integer> lottoResult = winningLotto.calculateResult(lottos);
        double profitRate = ProfitCalculator.calculateProfitRate(lottoResult, purchaseAmount);

        UserOutputView.outputWinningStatistics(lottoResult);
        UserOutputView.outputProfitRate(profitRate);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = UserInputView.inputPurchaseAmount();
                InputValidator.validatePurchaseAmount(inputPurchaseAmount);
                return Integer.parseInt(inputPurchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchaseLottos(purchaseAmount);
        UserOutputView.outputLottos(lottos);
        return lottos;
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = UserInputView.inputWinningNumbers();
                List<Integer> winningNumbers = parseWinningNumbers(inputWinningNumbers);
                InputValidator.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String inputWinningNumbers) {
        String[] numbers = inputWinningNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String inputBonusNumber = UserInputView.inputBonusNumber();
                int bonusNumber = Integer.parseInt(inputBonusNumber);
                InputValidator.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
