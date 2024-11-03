package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요. (1000원 단위로 입력)");
        return Console.readLine();
    }

    public static String getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (1부터 45사이의 수 6개를 콤마(,)로 구분해 입력)");
        return Console.readLine();
    }

    public static String getBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요. (1부터 45사이의 수 입력)");
        return Console.readLine();
    }

}
