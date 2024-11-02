package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    //    View는 Model 의존 가능, C의존 불가
    public int inputPurchaseMoney() {
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    //    당첨번호 입력
    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        List<Integer> winningNumbers = (Arrays.stream(input.split(","))
                .toList())
                .stream()
                .map(Integer::parseInt)
                .toList();

        return winningNumbers;
    }

    // 보너스 넘버
    public int inputBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
