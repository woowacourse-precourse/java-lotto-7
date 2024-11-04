package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    public static final int PRICE = 1000;

    // 구매 금액에 따라 로또를 생성
    public List<Lotto> purchase(int amount) {
        int count = amount / PRICE;

        return create(count);
    }

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
