package lotto.util;

import java.util.List;

public interface NumbersGenerator {
    List<Integer> generateNumbers(int start, int end, int count);
}
