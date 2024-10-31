package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return Console.readLine();
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] splitInput = input.split(",");

        return Arrays.stream(splitInput).map(Integer::parseInt).toList();
    }

    public int inputWinningBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        return Integer.parseInt(Console.readLine());
    }
}
