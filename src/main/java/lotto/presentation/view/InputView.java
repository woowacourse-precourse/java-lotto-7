package lotto.presentation.view;

import static lotto.common.ExceptionMessage.INVALID_NUMBER_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.common.validator.IssuedLottoValidator;
import lotto.common.validator.LottoResultValidator;
import lotto.common.validator.LottoValidator;

public class InputView {
    public int getValidPurchaseAmount() {
        try {
            String inputPurchaseAmount = inputValue("구입금액을 입력해 주세요.");
            validatePurchaseAmount(inputPurchaseAmount);
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_NUMBER_FORMAT.getMessage());
            return getValidPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidPurchaseAmount();
        }
    }

    public List<Integer> getValidWinningNumbers() {
        try {
            String inputWinningNumbers = inputValue("당첨 번호를 입력해 주세요.");
            String[] splitInputWinningNumbers = inputWinningNumbers.split(",");
            validateWinningNumbers(splitInputWinningNumbers);
            return Arrays.stream(splitInputWinningNumbers).map(winningNumber ->
                    Integer.parseInt(winningNumber)
            ).toList();
        } catch (NumberFormatException e) {
            System.out.println(INVALID_NUMBER_FORMAT.getMessage());
            return getValidWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidWinningNumbers();
        }
    }

    public int getValidBonusNumber(List<Integer> winningNumbers) {
        try {
            String inputBonusNumber = inputValue("보너스 번호를 입력해 주세요.");
            validateBonusNumber(inputBonusNumber, winningNumbers);
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_NUMBER_FORMAT.getMessage());
            return getValidBonusNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidBonusNumber(winningNumbers);
        }
    }

    private String inputValue(String placeholder) {
        System.out.println(placeholder);
        String input = Console.readLine().replace(" ", "");
        return input;
    }

    private void validatePurchaseAmount(String inputPurchaseAmount) {
        isDigit(inputPurchaseAmount);
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        IssuedLottoValidator.validate(purchaseAmount);
    }

    private void validateWinningNumbers(String[] splitInputWinningNumbers) {
        for (String winningNumber : splitInputWinningNumbers) {
            isDigit(winningNumber);
        }
        List<Integer> winningNumbers = Arrays.stream(splitInputWinningNumbers)
                .map(winningNumber -> Integer.parseInt(winningNumber)).toList();
        LottoValidator.validate(winningNumbers);
    }

    private void validateBonusNumber(String inputBonusNumber, List<Integer> winningNumbers) {
        isDigit(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        LottoResultValidator.bonusNumberValidate(bonusNumber, winningNumbers);
    }

    private void isDigit(String inputPurchaseAmount) {
        if (!inputPurchaseAmount.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
