package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public int getCost() {
        System.out.println("구입금액을 입력해 주세요.");
        String cost = Console.readLine(); // todo : 예외 처리
        return Integer.parseInt(cost); // todo : 예외 처리
    }

    public List<Integer> getWinningNums() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String winningNums = Console.readLine(); // todo : 예외 처리
        return Arrays.stream(winningNums.split(","))
                .map(String::trim)
                .map(Integer::parseInt).toList(); // todo : 예외 처리
    }

    public int getBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine(); // todo : 예외 처리
        return Integer.parseInt(bonusNum); // todo : 예외 처리
    }
}
