package lotto.testUtil.testDouble;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.numberPicker.NumberPicker;

public class NumberPickerFake implements NumberPicker {

    private final List<Integer> numbers = new ArrayList<>();
    private int index = 0;

    public void setNumbers(Integer... numbers) {
        this.numbers.addAll(List.of(numbers));
    }

    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            result.add(numbers.get(index));
            index = (index + 1) % numbers.size();
        }

        return result;
    }
}
