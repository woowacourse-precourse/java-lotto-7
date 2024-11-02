package lotto.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();

        // 1부터 45까지의 숫자를 리스트에 추가
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            numbers.add(i);
        }

        // 리스트를 섞어서 무작위 순서를 만들고 앞에서부터 6개 선택
        Collections.shuffle(numbers);
        List<Integer> selectedNumbers = new ArrayList<>(numbers.subList(0, LOTTO_NUMBER_COUNT));

        // 번호를 오름차순으로 정렬하여 반환
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }
}
