package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Utils;
import java.util.List;


public class Input {
    public static void askPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void askWinNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void askBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요");
    }

    public static int number() {
        return Utils.parseNumber(Console.readLine());
    }

    public static List<Integer> numbers() {
        return Utils.parseNumbers(Console.readLine());
    }
}
