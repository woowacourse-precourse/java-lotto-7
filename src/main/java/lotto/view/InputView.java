package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {

    public String requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        try {
            InputValidator.validatePurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestPurchaseAmount();
        }
        return purchaseAmount;
    }

    public String requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        try {
            InputValidator.validateWinningNumbersString(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestWinningNumbers();
        }
        return winningNumbers;
    }

    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        try {
            InputValidator.validateBonusNumberString(bonusNumber); // 숫자 범위 유효성 검증
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestBonusNumber();
        }
        return Integer.parseInt(bonusNumber); // 유효성 검증 후 숫자로 변환
    }
}