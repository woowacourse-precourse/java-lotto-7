package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AscendingSorter {
    public static List<Integer> run(List<Integer> list) {
        // 원본 리스트를 가변 리스트로 변환
        List<Integer> mutableList = new ArrayList<>(list);
        // 가변 리스트를 정렬
        Collections.sort(mutableList);
        return mutableList; // 정렬된 리스트 반환
    }
}
