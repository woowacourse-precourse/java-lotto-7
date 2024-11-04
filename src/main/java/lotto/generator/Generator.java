package lotto.generator;

import java.util.List;

public interface Generator {
    List<Integer> generateUniqueNumbers(int start, int end, int num);
}
