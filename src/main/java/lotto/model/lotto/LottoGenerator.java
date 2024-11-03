package lotto.model.lotto;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT)
                                        .stream()
                                        .sorted()
                                        .toList();
        return new Lotto(lottoNumbers);
    }

    // 로또 번호 여러 개 생성 메서드
    public static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }
}
