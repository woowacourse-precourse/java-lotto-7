package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class inputView {
    public static String purchase(){
        System.out.println("구입금액을 입력해 주세요.");

        return Console.readLine();
    }

    public static String winningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");

        return Console.readLine();
    }

    public static String bonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");

        return Console.readLine();
    }
}
