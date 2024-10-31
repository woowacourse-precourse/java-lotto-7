package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int getCost() {
//        System.out.println("구입금액을 임력해 주세요.");
        System.out.println("Input Purchase Cost");
        return Integer.parseInt(Console.readLine());
    }

    public static String getWinNumbers() {
//        System.out.println("당첨 번호를 입력해 주세요.");
        System.out.println("Input Win Numbers");
        return Console.readLine();
    }

    public static int getBonusNumber() {
//        System.out.println("보너스 번호를 입력해 주세요");
        System.out.println("Input Bonus Number");
        return Integer.parseInt(Console.readLine());
    }
}
