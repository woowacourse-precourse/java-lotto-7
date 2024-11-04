package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberPicker {
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Integer::compareTo); // 오름차순 정렬
        return new Lotto(numbers);
    }
}