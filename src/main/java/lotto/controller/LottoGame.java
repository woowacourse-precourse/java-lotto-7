package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.LottoRanking;
import lotto.domain.ReturnMoneyRate;
import lotto.validator.BonusValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.NumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private int money;
    private List<Integer> winningNumbers;
    private int bonus;

    public void initMoney() {
        while (true) {
            try {
                String inputMoney = InputView.getMoney();
                validateMoneyInput(inputMoney);
                break;
            }
            catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e);
            }
        }
        InputView.getCount(money);
        issueLotto(money);
    }

    private void validateMoneyInput(String inputMoney) {
        MoneyValidator.validateMoneyInputNotNull(inputMoney);
        MoneyValidator.validateMoneyIsNumeric(inputMoney);

        money = Integer.parseInt(inputMoney);
        MoneyValidator.validateMoneyPositive(money);
        MoneyValidator.validateMoneyDivisibleByThousand(money);
    }

    private void issueLotto(int money) {
        LottoIssuer lottoIssuer = new LottoIssuer();
        List<Lotto> issuedLottos = lottoIssuer.generateLottos(money);
        OutputView.displayIssuedLotto(issuedLottos);

        initWinningLotto(issuedLottos);
    }

    private void initWinningLotto(List<Lotto> issuedLottos) {
        winningNumbers = getValidatedWinningNumbers();
        bonus = getValidatedBonusNumber(winningNumbers);
        calculateLottoResult(issuedLottos, winningNumbers, bonus);
    }

    private List<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                String winningInput = InputView.getWinningNumbers();
                return validateWinningNumbers(winningInput);
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e);
            }
        }
    }

    private List<Integer> validateWinningNumbers(String winningInput) {
        String[] parsedWinningNumbers= winningInput.split(",");
        NumberValidator.validateWinningNumbersAreNumeric(parsedWinningNumbers);

        List<Integer> numbers = convertToIntegerList(parsedWinningNumbers);
        new Lotto(numbers);
        return numbers;
    }

    private List<Integer> convertToIntegerList(String[] winningNumberSplit) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : winningNumberSplit) {
            numbers.add(Integer.parseInt(s.trim()));
        }
        return numbers;
    }

    private int getValidatedBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusInput = InputView.getBonusNumber();
                bonus = validateBonusNumber(bonusInput);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e);
            }
        }
        return bonus;
    }

    private int validateBonusNumber(String bonusInput) {
        BonusValidator.validateBonusIsNumeric(bonusInput);

        bonus = Integer.parseInt(bonusInput.trim());
        BonusValidator.validateBonusNumberRange(bonus);
        BonusValidator.validateBonusNotDuplicated(winningNumbers, bonus);

        return bonus;
    }

    private void calculateLottoResult(List<Lotto> issuedLottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoRanking lottoRanking = new LottoRanking();
        Map<Integer, Integer> result = lottoRanking.calculateRank(issuedLottos, winningNumbers, bonusNumber);

        OutputView.displayResult(result);

        calculateReturnMoneyRate(result);
    }

    private void calculateReturnMoneyRate(Map<Integer, Integer> result) {
        ReturnMoneyRate returnMoneyRate = new ReturnMoneyRate();
        int totalWinnings = returnMoneyRate.calculateSum(result);
        double rateOfReturn = returnMoneyRate.calculateRate(totalWinnings, money);

        OutputView.displayMoneyRate(rateOfReturn);
    }
}
