package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.exception.CheckInput;

public class InputConsole {

    public static void inputConsole() {
        System.out.println("구매금액을 입력해 주세요.");
        int inputMoney = Integer.parseInt(readLine());

        CheckInput.checkInputMoney(inputMoney);

        System.out.println("당첨 번호를 입력해 주세요.");
    }

}
