package lotto.domain.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AscendingSorter implements Sorter {

    @Override
    public List<Integer> sort(List<Integer> numbers) {
        List<Integer> mutableList = new ArrayList<>(numbers);
        Collections.sort(mutableList);
        return mutableList;
    }
}
