package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class UserInputConverter {

    public int getCost() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();

        return Integer.parseInt(userInput);
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userWinningNumbers = Console.readLine();
        return Arrays.stream(userWinningNumbers.split(",")).map(Integer::parseInt).toList();
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String userBonusNumber = Console.readLine();
        return Integer.parseInt(userBonusNumber);
    }
}
