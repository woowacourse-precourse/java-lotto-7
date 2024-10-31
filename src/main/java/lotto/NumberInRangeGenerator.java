package lotto;

import java.util.List;

public interface NumberInRangeGenerator {

    List<Integer> randomGenerate(int start, int end, int cnt);
}
