package lotto.adapter.out.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.application.out.LottoGeneratorPort;
import lotto.config.context.annotation.Component;
import lotto.domain.core.Lotto;

@Component
public class LottoGeneratorAdapter implements LottoGeneratorPort {

    /* 로또 번호의 최소값 */
    private static final int LOTTO_MIN_NUMBER = 1;

    /* 로또 번호의 최대값 */
    private static final int LOTTO_MAX_NUMBER = 45;

    /* 로또 번호의 개수 */
    private static final int LOTTO_NUMBER_COUNT = 6;

    public LottoGeneratorAdapter() {
    }

    @Override
    public Lotto generate() {
        int[] randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return new Lotto(randomNumbers);
    }
}
