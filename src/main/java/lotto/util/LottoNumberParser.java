package lotto.util;

import java.util.Arrays;
import java.util.List;

public class LottoNumberParser {
    private LottoNumberParser() {
    }

    public static List<Integer> parseLottoNumbers(String inputLottoNumbers) {
        try {
            return Arrays.stream(inputLottoNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 \",\"로 구분된 정수여야 합니다.");
        }
    }
}
