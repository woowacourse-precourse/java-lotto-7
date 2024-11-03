package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    public static int buyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            return buyPrice();
        }
    }

    public static Set<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            return inputWinningNumbers();
        }
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            return inputBonusNumber();
        }
    }


}
