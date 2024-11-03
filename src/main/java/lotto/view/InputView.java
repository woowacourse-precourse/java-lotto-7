package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static int purchaseAmount;

    public static int getPurchaseAmount() {
        return purchaseAmount;
    }

    public static int purchaseAmount() {
        OutputView.purchaseAmount();
        purchaseAmount = Integer.parseInt(Console.readLine());
        return purchaseAmount;
    }

    public static List<Integer> winningNumber() {
        OutputView.userNumber();
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int bonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
