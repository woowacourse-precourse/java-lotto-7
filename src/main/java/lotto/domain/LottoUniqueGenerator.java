package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUniqueGenerator implements LottoGenerator {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    private static LottoUniqueGenerator lottoShuffleGenerator;

    private LottoUniqueGenerator() {

    }

    public static LottoUniqueGenerator getLottoUniqueGenerator() {
        if (lottoShuffleGenerator == null) {
            lottoShuffleGenerator = new LottoUniqueGenerator();
        }
        return lottoShuffleGenerator;
    }

    @Override
    public List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> purChasedLotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            purChasedLotto.add(sortLotto(generateUniqueLotto()));
        }
        return purChasedLotto;
    }

    List<Integer> generateUniqueLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
    }

    Lotto sortLotto(List<Integer> shuffledLotto) {
        Collections.sort(shuffledLotto);
        return new Lotto(shuffledLotto);
    }

}
