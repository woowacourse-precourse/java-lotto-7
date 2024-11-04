package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validate.LottoValidator;
import lotto.enums.InputMessage;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final static String LOTTO_NUMBERS_SPLIT_STRING = ",";

    public static int inputPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT_INPUT.getMessage());
        String purchaseAmount = Console.readLine();

        LottoValidator.validateInteger(purchaseAmount);
        LottoValidator.validatePurchaseAmountPositive(Integer.parseInt(purchaseAmount));
        LottoValidator.validatePurchaseAmountUnit(Integer.parseInt(purchaseAmount));

        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> inputLottoNumbers() {
        System.out.println(InputMessage.PRICE_NUMBERS_INPUT.getMessage());
        List<String> lottoNumbers = Arrays.stream(Console.readLine().split(LOTTO_NUMBERS_SPLIT_STRING)).toList();

        LottoValidator.validateNumbersInteger(lottoNumbers);
        LottoValidator.validateLottoNumbersRange(lottoNumbers);

        return lottoNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static int inputLottoBonusNumber(Lotto winningNumbers) {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT.getMessage());
        String bonusNumber = Console.readLine();

        LottoValidator.validateInteger(bonusNumber);
        LottoValidator.validateLottoNumberRange(Integer.parseInt(bonusNumber));
        LottoValidator.validateLottoBonusNumberDuplication(winningNumbers, Integer.parseInt(bonusNumber));

        return Integer.parseInt(bonusNumber);
    }
}
