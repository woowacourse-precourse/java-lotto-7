package lotto.domain.sorting;

import java.util.Collections;
import java.util.List;

public class AscendingSorter implements Sorter {
    
    @Override
    public List<Integer> sort(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
