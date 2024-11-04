package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Integer> parseNumbers(String input) {
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            int number = Integer.parseInt(part.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            numbers.add(number);
        }
        return numbers;
    }
}
