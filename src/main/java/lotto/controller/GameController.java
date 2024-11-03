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
        String inputPurchaseAmount = UserInputView.inputPurchaseAmount();

        try {
            InputValidator.validatePurchaseAmount(inputPurchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }

        return Integer.parseInt(inputPurchaseAmount);
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchaseLottos(purchaseAmount);
        UserOutputView.outputLottos(lottos);
        return lottos;
    }

    private List<Integer> getWinningNumbers() {
        String inputWinningNumbers = UserInputView.inputWinningNumbers();
        List<Integer> winningNumbers = parseWinningNumbers(inputWinningNumbers);

        try {
            InputValidator.validateWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }

        return winningNumbers;
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
        String inputBonusNumber = UserInputView.inputBonusNumber();
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        try {
            InputValidator.validateBonusNumber(bonusNumber, winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }

        return bonusNumber;
    }
}
