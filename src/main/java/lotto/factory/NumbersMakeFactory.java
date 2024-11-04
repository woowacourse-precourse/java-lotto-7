package lotto.factory;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Numbers;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class NumbersMakeFactory {

    public static Numbers getNumbers() {
        Lotto winningNumbers = getWinningNumbers(InputView.getWinnerNumbers());
        System.out.println();
        int bonusNumber = getBonusNumber(InputView.getBonusNumber());
        return createNumbers(winningNumbers, bonusNumber);
    }

    public static Numbers createNumbers(Lotto winningNumbers, int bonusNumber) {
        try {
            return new Numbers(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return createNumbers(winningNumbers, getBonusNumber(InputView.getBonusNumber()));
        }
    }

    public static int getBonusNumber(String bonusNumber) {
        try {
            return Validator.validateInteger(bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getBonusNumber(InputView.getBonusNumber());
        }
    }

    public static Lotto getWinningNumbers(String winningNumbers) {
        try{
            return new Lotto(validateWinningNumbers(winningNumbers));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getWinningNumbers(InputView.getWinnerNumbers());
        }
    }

    public static List<Integer> validateWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(Validator::validateInteger)
                .collect(toList());
    }
}
