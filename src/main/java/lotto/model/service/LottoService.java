package lotto.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoMachine;
import lotto.model.domain.LottoPrize;
import lotto.model.domain.LottoWinningNumbers;
import lotto.model.domain.Pocket;

public class LottoService {

    public int moneyValidator(String inputMoney) {
        moneyNotNullValidator(inputMoney);
        return moneyNumberValidator(inputMoney);
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
        bonusNumbersNotNullValidator(bonusNumber);
        int bonusNumericNumber = bonusNumberNumericValidator(bonusNumber);
        return new BonusNumber(bonusNumericNumber);
    }

    private int bonusNumberNumericValidator(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야합니다.");
        }
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

    private void bonusNumbersNotNullValidator(String bonusNumber) {
        if (bonusNumber.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 입력되지 않았습니다.");
        }
    }

    private void moneyNotNullValidator(String inputMoney) {
        if (inputMoney.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또를 구매하려는 금액을 입력해 주세요.");
        }
    }

    private int moneyNumberValidator(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또를 구매하려는 금액을 숫자로 입력해 주세요.");
        }
    }

    private void winningNumbersNotNullValidator(String inputWinningNumbers) {
        if (inputWinningNumbers.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 입력되지 않았습니다.");
        }
    }

    private List<Integer> winningNumbersParser(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(",",-1))
                .map(String::trim)
                .map(this::winningNumbersNumericValidator)
                .toList();
    }

    private int winningNumbersNumericValidator(String inputWinningNumbers) {
        try {
            return Integer.parseInt(inputWinningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야합니다.");
        }
    }

}
