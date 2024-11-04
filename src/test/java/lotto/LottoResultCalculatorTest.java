package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.BonusNumber;
import lotto.model.LottoGenerator;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.LottosResult;
import lotto.model.LottosResultCalculator;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultCalculatorTest {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Test
    void 발행한_모든_로또들의_당첨_여부가_판별되었는지_테스트() {
        assertSimpleTest(() -> {
            // given
            int predictQuantity = 5;
            LottoGenerator lottoGenerator = new LottoGenerator();
            Lottos lottos = lottoGenerator.issue(predictQuantity);
            WinningNumbers winningNumbers = WinningNumbers.from(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT));
            BonusNumber bonusNumber = BonusNumber.from(Randoms.pickNumberInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
            while (winningNumbers.contains(bonusNumber.getBonusNumber())) {
                bonusNumber = BonusNumber.from(Randoms.pickNumberInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
            }
            LottosResultCalculator lottosResultCalculator = LottosResultCalculator.of(lottos, winningNumbers, bonusNumber);

            // when
            lottosResultCalculator.calculateLottosResult();
            LottosResult lottosResult = lottosResultCalculator.getLottosResult();
            int actualQuantity = 0;
            for (LottoRank lottoRank : LottoRank.getAllLottoRank(true)) {
                actualQuantity += lottosResult.get(lottoRank);
            }

            // then
            assertThat(actualQuantity).isEqualTo(predictQuantity);
        });
    }
}
