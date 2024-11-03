package lotto.View.Input;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static void InputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine().trim();
    }

    public static void Attempt(int money) {
        System.out.println();
        int attempt = money / 1000;
        System.out.println(attempt+"개를 구매했습니다.");
    }

    public static void InputNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String number = Console.readLine();
    }

    public static void InputBonus() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
    }
}
