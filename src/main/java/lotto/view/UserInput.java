package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class UserInput {

    public int inputMoney() {
        System.out.println("로또 구입 금액을 입력해주세요.");
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨번호를 입력해주세요.");
        List<Integer> winningNumbers = List.of(Console.readLine().split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스번호를 입력해주세요.");
        String bonusNumber = Console.readLine();

        return Integer.parseInt(bonusNumber);
    }
}
