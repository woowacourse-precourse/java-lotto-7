package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    // 로또 구입 금액 입력 메소드
    public int purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        System.out.println();
        return amount;
    }

    // 당첨 번호 입력 메소드
    public List<Integer> winningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNum = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println();
        return winningNum;
    }

    // 보너스 번호 입력 메소드
    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonus;
    }
}
