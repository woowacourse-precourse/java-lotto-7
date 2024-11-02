package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.LottoRanking;
import lotto.domain.ReturnMoneyRate;
import lotto.validator.MoneyValidator;
import lotto.validator.NumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private int money;

    public void initMoney() {
        while (true) {
            try {
                String inputMoney = InputView.getMoney();
                MoneyValidator.validateInputMoney(inputMoney);

                money = Integer.parseInt(inputMoney);
                MoneyValidator.validateMoney(money);
                MoneyValidator.validatePurchaseAmount(money);

                break;
            }
            catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e);
            }
        }
        InputView.getCount(money);
        issueLotto(money);
    }

    private void issueLotto(int money) {
        LottoIssuer lottoIssuer = new LottoIssuer();
        List<Lotto> issuedLottos = lottoIssuer.generateLottos(money);
        OutputView.displayIssuedLotto(issuedLottos);

        initWinningLotto(issuedLottos);
    }

    private void initWinningLotto(List<Lotto> issuedLottos) {
        List<Integer> winningNumbers = getWinningNumbersFromUser();
        int bonusNumber = getBonusNumberFromUser(winningNumbers);
        calculateLotto(issuedLottos, winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbersFromUser() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                String winning = InputView.getWinningNumbers();
                String[] winningNum = winning.split(",");
                NumberValidator.validateInput(winningNum);
                winningNumbers = convertToIntegerList(winningNum);
                new Lotto(winningNumbers);
                NumberValidator.validateNumberRange(winningNumbers);
                NumberValidator.validateNoDuplicates(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e);
            }
        }
        return winningNumbers;
    }

    private List<Integer> convertToIntegerList(String[] winningNum) {
        List<Integer> result = new ArrayList<>();
        for (String s : winningNum) {
            result.add(Integer.parseInt(s.trim()));
        }
        return result;
    }

    private int getBonusNumberFromUser(List<Integer> winningNumbers) {
        int bonus = -1;
        while (true) {
            try {
                String bonusNumber = InputView.getBonusNumber();
                NumberValidator.validateInputBonus(bonusNumber);
                bonus = Integer.parseInt(bonusNumber.trim());
                NumberValidator.validateBonusNumberRange(bonus);
                NumberValidator.validateNoDuplicatesBonus(winningNumbers, bonus);

                break;
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e);
            }
        }
        return bonus;
    }

    private void calculateLotto(List<Lotto> issuedLottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoRanking lottoRanking = new LottoRanking();
        Map<String, Integer> result = lottoRanking.calculateRank(issuedLottos, winningNumbers, bonusNumber);

        OutputView.displayResult(result);

        calculateReturnMoneyRate(result);
    }

    private void calculateReturnMoneyRate(Map<String, Integer> result) {
        ReturnMoneyRate returnMoneyRate = new ReturnMoneyRate();
        int sum = returnMoneyRate.calculateSum(result);
        double moneyRate = returnMoneyRate.calculateRate(sum, money);

        OutputView.displayMoneyRate(moneyRate);
    }
}
