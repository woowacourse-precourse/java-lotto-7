package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumbersValidator;
import lotto.validator.PurchaseAmountValidator;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String getValidatePurchaseAmount() {
        String purchaseAmount;

        while (true) {
            try {
                purchaseAmount = getPurchaseAmount();
                PurchaseAmountValidator.validate(purchaseAmount);
                break ;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    public String getValidateLottoNumbers() {
        String lottoNumbers;

        while (true) {
            try {
                lottoNumbers = getLottoNumbers();
                LottoNumbersValidator.validate(lottoNumbers);
                break ;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoNumbers;
    }

    public String getValidateBonusNumber(String[] lottoNumbers) {
        String bonusNumber;

        while (true) {
            try {
                bonusNumber = getBonusNumber();
                BonusNumberValidator.validate(bonusNumber, lottoNumbers);
                break ;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private String getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return readLine();
    }

    private String getLottoNumbers() {
        System.out.println(LOTTO_NUMBERS_INPUT_MESSAGE);
        return readLine();
    }

    private String getBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return readLine();
    }

    private String readLine() {
        String rawInput = Console.readLine();
        if (rawInput == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getMessage());
        }
        return rawInput.trim();
    }
}
