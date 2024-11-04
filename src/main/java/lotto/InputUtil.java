package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtil {

    public static int insertMoney() {
        String inputMoney = Console.readLine();
        // TODO: 숫자가 맞는지 검증 필요
        return Integer.parseInt(inputMoney) / 1000;
    }

    public static List<Integer> insertWinningNumbers() {
        String[] inputNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputNumbers) {
            // TODO: 중복된 숫자 방지
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public static Integer insertBonusNumber() {
        // TODO: 숫자가 맞는지 검증 필요
        return Integer.parseInt(Console.readLine());
    }
}
