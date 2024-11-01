package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static String getPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static Lotto getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");
        return new Lotto(Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
