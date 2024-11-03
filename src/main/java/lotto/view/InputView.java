package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 구입 금액 입력 받기
     */
    public static String getPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    /**
     * 당첨 번호 입력 받기
     */
    public static String getPrizeNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    /**
     * 보너스 번호 입력 받기
     */
    public static String getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

}
