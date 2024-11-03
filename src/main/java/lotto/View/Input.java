package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static String money;
    private static String number;
    private static String bonus;

    public static void InputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        money = Console.readLine().trim();
    }

    public static void Attempt(int money) {
        System.out.println();
        int attempt = money / 1000;
        System.out.println(attempt+"개를 구매했습니다.");
    }

    public static void InputNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        number = Console.readLine();
    }

    public static void InputBonus() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = Console.readLine();
    }

    public static String GetMoney() {
        InputMoney();
        return money;
    }

    public static String GetNumber() {
        InputNumbers();
        return number;
    }

    public static String GetBonus() {
        InputBonus();
        return bonus;
    }
}
