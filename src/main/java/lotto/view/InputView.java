package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.BonusNumberValidation;
import lotto.validation.WinningNumberValidation;

import static lotto.util.PurchaseUtils.getThousandUnitCount;

public class InputView {
    public int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputPurchaseAmount = Console.readLine();
                return getThousandUnitCount(inputPurchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void readWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨번호를 입력해 주세요.");
                String inputWinningNumbers = Console.readLine();
                WinningNumberValidation.validate(inputWinningNumbers);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void readBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine();
                BonusNumberValidation.validate(inputBonusNumber);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
