package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputPrice() {
        printInputPrice();
        return Console.readLine();
    }

    public String inputWinningNumber() {
        printInputWinningNumbers();
        return Console.readLine();
    }

    public String inputBonusNumber() {
        printInputBonusNumber();
        return Console.readLine();
    }

    private void printInputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    private void printInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
