package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoPrintMessages;

public class InputView {
    public static int readPurchaseAmount() {
        System.out.print(LottoPrintMessages.INPUT_LOTTO_AMOUNT);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> readUserLotto() {
        System.out.print(LottoPrintMessages.INPUT_USERLOTTO);
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        System.out.print(LottoPrintMessages.INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}
