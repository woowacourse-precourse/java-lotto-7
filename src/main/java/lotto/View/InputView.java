package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputPurchasePrice() {
        System.out.println("구입금액을 입력해주세요");
        String input = Console.readLine();

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요.");
        }

        return Integer.parseInt(input);
    }

    public String[] setWinningNumber() {
        System.out.println("당첨 번호를 쉼표로 구분해 입력해 주세요 당첨번호는 1~45까지 6자리 수 입니다");
        return Console.readLine().split(",");
    }

    public int setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        return Integer.parseInt(Console.readLine());
    }
}
