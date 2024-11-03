package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        return Console.readLine();
    }

    public List<Integer> readWinningLotto() {
        System.out.println("\n" + "당첨 번호를 입력해주세요.");
        String rawWinningNumbers = Console.readLine();
        return parseToNumbers(rawWinningNumbers);
    }

    private List<Integer> parseToNumbers(String rawWinningNumbers) {
        return Arrays.stream(rawWinningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
