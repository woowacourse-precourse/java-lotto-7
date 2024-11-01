package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println("구입 금액을 1,000원 단위로 입력해주세요");
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요. (쉼표로 구분)");
        return Arrays.stream(Console.readLine().split(","))
                     .map(Integer::parseInt)
                     .sorted()
                     .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
