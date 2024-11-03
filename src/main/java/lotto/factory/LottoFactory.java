package lotto.factory;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    public static final int PRICE = 1000;

    public static List<Lotto> create(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // 1부터 45 사이의 중복되지 않는 6개의 랜덤 숫자를 선택
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()  // 오름차순 정렬
                    .collect(Collectors.toList());

            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
