package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.PurchaseAmount;
import domain.winning.BonusNumber;
import domain.winning.WinningNumbers;

public class InputView {

    public PurchaseAmount inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return createPurchaseAmount(Console.readLine());
    }

    public PurchaseAmount createPurchaseAmount(String input) {
        try {
            return new PurchaseAmount(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputPurchaseAmount();
        }
    }

    public WinningNumbers inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return createWinningNumbers(Console.readLine());
    }

    public WinningNumbers createWinningNumbers(String input) {
        try {
            return new WinningNumbers(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputWinningNumbers();
        }
    }

    public BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        return createBonusNumber(Console.readLine(), winningNumbers);
    }

    public BonusNumber createBonusNumber(String input, WinningNumbers winningNumbers) {
        try {
            Console.close();
            return new BonusNumber(input, winningNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }
}
