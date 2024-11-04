package lotto.domain.numberPicker;

import java.util.List;

public interface NumberPicker {

    List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count);
}
