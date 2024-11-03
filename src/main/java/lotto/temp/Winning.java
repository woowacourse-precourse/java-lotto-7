package lotto.temp;

import java.util.Arrays;
import java.util.List;

public class Winning {
    // TODO: 문자열 분리와 정수 리스트 변경을 한번에 하고 있음. 수정 필요
    public List<Integer> createWinningNumbers(String rawWinningNumbers) {
        String[] numbers = rawWinningNumbers.split(",");

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }
}
