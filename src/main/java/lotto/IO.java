package lotto;

import camp.nextstep.edu.missionutils.Console;

public class IO {
    public String payment() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String winningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String bonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void printOutput(String output) {
        System.out.println(output);
    }

    public void printError(String error) {
        System.out.println(error);
    }
}
