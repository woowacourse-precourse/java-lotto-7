package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {

    public String  inputPurchase() {
        System.out.println("구매금액을 입력해 주세요.");
        return Console.readLine();
    }



    public String inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
