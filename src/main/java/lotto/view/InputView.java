package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.Validate;
import lotto.enums.InputMessage;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final static String LOTTO_NUMBERS_SPLIT_STRING = ",";

    public static int inputPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT_INPUT.getMessage());
        String purchaseAmount = Console.readLine();

        Validate.validateInteger(purchaseAmount);
        Validate.validatePurchaseAmountPositive(Integer.parseInt(purchaseAmount));
        Validate.validatePurchaseAmountUnit(Integer.parseInt(purchaseAmount));

        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> inputLottoNumbers() {
        System.out.println(InputMessage.PRIZE_NUMBERS_INPUT.getMessage());
        List<String> lottoNumbers = Arrays.stream(Console.readLine().split(LOTTO_NUMBERS_SPLIT_STRING)).toList();

        Validate.validateNumbersInteger(lottoNumbers);
        Validate.validateLottoNumbersRange(lottoNumbers);

        return lottoNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static int inputLottoBonusNumber(Lotto winningNumbers) {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT.getMessage());
        String bonusNumber = Console.readLine();

        Validate.validateInteger(bonusNumber);
        Validate.validateLottoNumberRange(Integer.parseInt(bonusNumber));
        Validate.validateLottoBonusNumberDuplication(winningNumbers, Integer.parseInt(bonusNumber));

        return Integer.parseInt(bonusNumber);
    }
}
