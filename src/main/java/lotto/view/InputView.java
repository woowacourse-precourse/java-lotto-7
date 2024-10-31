package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.StringParser;

import java.util.List;

public class InputView {
    public InputView() {
    }

    public int readPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(Console.readLine());

        if (purchaseAmount < 0 || purchaseAmount % 1000 != 0) {
            System.out.println("ERROR");
        }

        return purchaseAmount;
    }

    public List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        return StringParser.parseToIntegerList(input);
    }

    public int readBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
