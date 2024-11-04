package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.InputValidator;
import lotto.enums.InputMessage;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final static String LOTTO_NUMBERS_SPLIT_STRING = ",";

    public static int inputPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT_INPUT.getMessage());
        String purchaseAmount = Console.readLine();

        InputValidator.validateInteger(purchaseAmount);
        InputValidator.validatePurchaseAmountPositive(Integer.parseInt(purchaseAmount));
        InputValidator.validatePurchaseAmountUnit(Integer.parseInt(purchaseAmount));

        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> inputLottoNumbers() {
        System.out.println(InputMessage.PRIZE_NUMBERS_INPUT.getMessage());
        List<String> lottoNumbers = Arrays.stream(Console.readLine().split(LOTTO_NUMBERS_SPLIT_STRING)).toList();

        InputValidator.validateNumbersInteger(lottoNumbers);
        InputValidator.validateLottoNumbersRange(lottoNumbers);

        return lottoNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static int inputLottoBonusNumber(Lotto winningNumbers) {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT.getMessage());
        String bonusNumber = Console.readLine();

        InputValidator.validateInteger(bonusNumber);
        InputValidator.validateLottoNumberRange(Integer.parseInt(bonusNumber));
        InputValidator.validateLottoBonusNumberDuplication(winningNumbers, Integer.parseInt(bonusNumber));

        return Integer.parseInt(bonusNumber);
    }
}
