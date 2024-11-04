package lotto.model.service;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoMachine;
import lotto.model.domain.LottoPrize;
import lotto.model.domain.LottoWinningNumbers;
import lotto.model.domain.Pocket;

public class LottoService {

    public int moneyValidator(String inputMoney) {
        moneyNotNullValidator(inputMoney);
        return moneyNumericValidator(inputMoney);
    }

    public List<Lotto> activateLottoMachine(int money) {
        LottoMachine lottoMachine = new LottoMachine(money);
        return lottoMachine.multipleLottoGenerator();
    }

    public Lotto winningNumbersGenerator(String inputWinningNumbers) {
        winningNumbersNotNullValidator(inputWinningNumbers);
        return new Lotto(winningNumbersParser(inputWinningNumbers));
    }

    public BonusNumber bonusNumberGenerator(String bonusNumber) {
        bonusNumberNotNullValidator(bonusNumber);
        int bonusNumericNumber = bonusNumberNumericValidator(bonusNumber);
        return new BonusNumber(bonusNumericNumber);
    }


    public void calculateReward(LottoWinningNumbers lottoWinningNumbers, Pocket pocket, LottoPrize lottoPrize) {
        for (Lotto lotto : pocket.getLottos()) {
            int matchNumberCount = 0;
            boolean isMatchBonus = false;
            for (int number : lotto.getNumbers()) {
                matchNumberCount = checkMatchNumber(lottoWinningNumbers, number, matchNumberCount);
                isMatchBonus = checkMatchBonus(lottoWinningNumbers, number, isMatchBonus);
            }
            lottoPrize.updateReward(matchNumberCount, isMatchBonus);
        }
    }

    private int checkMatchNumber(LottoWinningNumbers lottoWinningNumbers, int number, int matchNumberCount) {
        if (lottoWinningNumbers.isContainsWinningNumbers(number)) {
            matchNumberCount++;
        }
        return matchNumberCount;
    }

    private boolean checkMatchBonus(LottoWinningNumbers lottoWinningNumbers, int number, boolean isMatchBonus) {
        if (!isMatchBonus && lottoWinningNumbers.isContainsBonusNumber(number)) {
            isMatchBonus = true;
        }
        return isMatchBonus;
    }

    private int bonusNumberNumericValidator(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NUMERIC_VALIDATOR.getMessage());
        }
    }


    private void bonusNumberNotNullValidator(String bonusNumber) {
        if (bonusNumber == null || bonusNumber.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_NULL_VALIDATOR.getMessage());
        }
    }

    private void moneyNotNullValidator(String inputMoney) {
        if (inputMoney == null || inputMoney.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_NULL_VALIDATOR.getMessage());
        }
    }

    private int moneyNumericValidator(String inputMoney) {
        inputMoney = inputMoney.trim();
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NUMERIC_VALIDATOR.getMessage());
        }
    }

    private void winningNumbersNotNullValidator(String inputWinningNumbers) {
        if (inputWinningNumbers == null || inputWinningNumbers.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_NOT_NULL_VALIDATOR.getMessage());
        }
    }

    private List<Integer> winningNumbersParser(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(",", -1))
                .map(String::trim)
                .map(this::winningNumbersNumericValidator)
                .toList();
    }

    private int winningNumbersNumericValidator(String inputWinningNumbers) {
        try {
            return Integer.parseInt(inputWinningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_NUMERIC_VALIDATOR.getMessage());
        }
    }

}
