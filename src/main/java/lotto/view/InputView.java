package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static String requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<String> requestWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        return Arrays.asList(inputWinningNumbers.split(","));
    }

    public static String requestBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
