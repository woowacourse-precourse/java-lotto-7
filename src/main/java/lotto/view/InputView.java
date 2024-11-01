package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static int readPurchaseAmount() {
        System.out.print("로또 구입 금액을 입력해 주세요: ");
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> readUserLotto() {
        System.out.print("당첨 번호를 입력해 주세요: ");
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        System.out.print("보너스 번호를 입력해 주세요: ");
        return Integer.parseInt(Console.readLine());
    }
}
