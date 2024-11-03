package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class lottoView {

    public static String purchaseInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();

        return input;
    }

    public static String winningInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();

        return input;
    }

    public static String bonusInput(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();

        return input;
    }

}
