package lotto.validator;

import java.util.List;
import lotto.enums.LottoConfig;

public class LottoValidator {

    public static void lottoNumSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void lottoNumDup(List<Integer> numbers)  {
        for (int num : numbers) {
            if (numbers.indexOf(num) != numbers.lastIndexOf(num)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }

    public static void lottoNumRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < LottoConfig.LOTTO_NUM_START.getValue() || num > LottoConfig.LOTTO_NUM_END.getValue()) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지만 가능합니다.");
            }
        }
    }
}




