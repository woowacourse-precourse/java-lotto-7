package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static String requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<Integer> requestWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        return Arrays.stream(inputWinningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int requestBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
