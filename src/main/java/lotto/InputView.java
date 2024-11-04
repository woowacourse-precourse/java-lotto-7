package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String LOTTO_NUMBERS_DELIMITER = ",";

    public long promptAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return Long.parseLong(input);
    }

    public List<Integer> promptWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Arrays.stream(input.split(LOTTO_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}
