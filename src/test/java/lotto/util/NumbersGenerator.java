package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class NumbersGenerator {
    public static final List<Integer> MAIN_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    public static final int BONUS_NUMBER = 7;
    public static final List<Integer> EXCLUSIVE_WITH_MAIN_NUMBERS = List.of(10,11,12,13,14,15);

    public static List<Integer> createLottoNumbers(int mainCount, int exclusiveMainCount) {
        List<Integer> numbers = new ArrayList<>(MAIN_NUMBERS.subList(0, mainCount));
        numbers.addAll(EXCLUSIVE_WITH_MAIN_NUMBERS.subList(0, exclusiveMainCount));
        return numbers;
    }

    public static List<Integer> createLottoNumbersWithBonusNumber(int mainCount, int exclusiveMainCount) {
        List<Integer> numbers = createLottoNumbers(mainCount, exclusiveMainCount);
        numbers.add(BONUS_NUMBER);
        return numbers;
    }
}
