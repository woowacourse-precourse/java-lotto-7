package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }
    public int getBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
