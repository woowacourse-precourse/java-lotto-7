package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public String readPurchaseAmount() {
        print("구입금액을 입력해주세요.");
        return Console.readLine();
    }

    public List<Integer> readWinningNumbers() {
        print("\n" + "당첨 번호를 입력해주세요.");
        String rawWinningNumbers = Console.readLine();
        return parseToNumbers(rawWinningNumbers);
    }

    private List<Integer> parseToNumbers(String rawWinningNumbers) {
        return Arrays.stream(rawWinningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public String readBonusNumber() {
        print("\n" + "보너스 번호를 입력해주세요.");
        return Console.readLine();
    }

    private void print(String value) {
        System.out.println(value);
    }
}
