package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.common.validator.IssuedLottoValidator;
import lotto.common.validator.LottoResultValidator;
import lotto.common.validator.LottoValidator;

public class InputView {
    public int getValidPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String inputPurchaseAmount = Console.readLine().replace(" ", "");
            validatePurchaseAmount(inputPurchaseAmount);
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식이 잘못되었습니다. 다시 입력해주세요.");
            return getValidPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidPurchaseAmount();
        }
    }

    public List<Integer> getValidWinningNumbers() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String inputWinningNumbers = Console.readLine().replace(" ", "");
            String[] splitInputWinningNumbers = inputWinningNumbers.split(",");
            validateWinningNumbers(splitInputWinningNumbers);
            return Arrays.stream(splitInputWinningNumbers).map(winningNumber ->
                    Integer.parseInt(winningNumber)
            ).toList();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식이 잘못되었습니다. 다시 입력해주세요.");
            return getValidWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidWinningNumbers();
        }
    }

    public int getValidBonusNumber(List<Integer> winningNumbers) {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String inputBonusNumber = Console.readLine().replace(" ", "");
            validateBonusNumber(inputBonusNumber, winningNumbers);
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식이 잘못되었습니다. 다시 입력해주세요.");
            return getValidBonusNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidBonusNumber(winningNumbers);
        }
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
            throw new IllegalArgumentException("[ERROR] 값은 숫자로 입력해주세요.");
        }
    }
}
