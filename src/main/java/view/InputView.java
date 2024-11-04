package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static void inputLottoPurchase() {
        System.out.println("구입 금액을 입력해주세요.");
        Console.readLine();
    }

    public static void inputLottoNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        Console.readLine();
    }

    public static void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요");
        Console.readLine();
    }
}
