package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Integer::compareTo); // 번호 오름차순 정렬
        return new Lotto(numbers);
    }
}