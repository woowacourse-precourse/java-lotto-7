package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.validation.BonusNumberValidator;
import lotto.validation.LottoNumberValidator;
import lotto.validation.LottoNumbersValidator;
import lotto.validation.LottoPurchaseValidator;

public class InputView {
    public static int inputLottoPurchase() {
        String lottoPurchase = Console.readLine();
        LottoPurchaseValidator.validate(lottoPurchase);
        return Integer.parseInt(lottoPurchase);
    }

    public static Lotto inputWinningNumbers() {
        String winningNumber = Console.readLine();
        LottoNumberValidator.validateWinningNumbers(winningNumber);
        List<Integer> winningNumbers = Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .toList();
        LottoNumbersValidator.validate(winningNumbers);
        return new Lotto(winningNumbers);
    }

    public static int inputBonusNumber() {
        String BonusNumber = Console.readLine();
        BonusNumberValidator.validate(BonusNumber);
        return Integer.parseInt(BonusNumber);
    }
}
