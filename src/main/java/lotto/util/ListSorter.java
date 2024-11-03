package lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ListSorter {

    public static List<Integer> ascending(List<Integer> numbers) {
        // 전달된 리스트가 수정 불가능한 경우 새로운 리스트로 복사
        List<Integer> sortableList = new ArrayList<>(numbers);
        Collections.sort(sortableList);
        return sortableList;
    }
}
