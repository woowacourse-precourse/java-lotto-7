package InputOutput;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static String insert() {
        return Console.readLine();
    }
    public static List<Integer> random() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static List<Integer> winNumbers(){
        String input = InputView.insert();
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분되어야 합니다.");
        }

        String[] parts = input.split(",");
        List<Integer> winNumbers = new ArrayList<>();


        for (String part : parts) {
            part = part.trim();
            validateWinNumber(part);
            int number = Integer.parseInt(part);
            if (winNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            }
            winNumbers.add(number);
        }
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        return winNumbers;
    }
    private static void validateWinNumber(String part) {
        if (!part.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }

        int number = Integer.parseInt(part);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
        }
    }
}
