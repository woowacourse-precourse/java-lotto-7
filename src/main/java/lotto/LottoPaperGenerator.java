package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.Constant.*;

public class LottoPaperGenerator {
    private LottoPaperGenerator() {
    }

    public static LottoPaper createLottoPaper(int cost) {
        List<Lotto> lottos = IntStream.range(0, cost / LOTTO_CHARGE)
                .mapToObj(it -> new Lotto(createLottoNumbers()))
                .toList();

        return new LottoPaper(lottos);
    }

    private static List<Integer> createLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_NUMBERS_LIMIT);
        List<Integer> lottoNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
