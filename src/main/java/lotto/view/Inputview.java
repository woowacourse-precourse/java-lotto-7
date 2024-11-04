package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Inputview {

    // 구입 금액 입력
    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine(); // String으로 반환
    }

    // 당첨 번호 입력
    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    // 보너스 번호 입력
    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
