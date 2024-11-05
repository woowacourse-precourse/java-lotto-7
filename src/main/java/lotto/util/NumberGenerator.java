package lotto.util;

import java.util.List;

public interface NumberGenerator {
    List<Integer> getNumber(int min, int max, int size);
}
