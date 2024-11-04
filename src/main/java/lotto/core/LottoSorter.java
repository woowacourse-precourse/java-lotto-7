package lotto.core;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class LottoSorter {
    public static List<Integer> sort(List<Integer> numbers){
        List<Integer> mutableNumbers = new ArrayList<>(numbers); // 복사하여 변경 가능한 리스트 생성
        Collections.sort(mutableNumbers);
        return mutableNumbers;

    }
}
