package lotto.service.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.lotto.Lotto;

public class LottoGenerator {
    public static List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream()
                        .sorted() // 로또 번호 리스트를 오름차순으로 정렬
                        .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}
