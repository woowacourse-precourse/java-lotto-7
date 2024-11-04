package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {
    @DisplayName("상금의 전체 합을 구한다")
    @Test
    void 상금의_전체_합을_구한다() {
        // given
        // 테스트 상태 1등, 5등 당첨
        final List<Integer> LOTTO_NUMBERS_1 = Arrays.asList(1, 3, 5, 7, 9, 11);
        final List<Integer> LOTTO_NUMBERS_2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        final List<Integer> WINNING_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
        final String BONUS_NUMBER = "7";

        Lotto lotto1 = new Lotto(LOTTO_NUMBERS_1);
        Lotto lotto2 = new Lotto(LOTTO_NUMBERS_2);
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));

        WinningNumbers winningNumbers = WinningNumbers.from(WINNING_NUMBERS);
        BonusNumber bonusNumber = new BonusNumber(BONUS_NUMBER, winningNumbers);
        DrawnNumbers drawnNumbers = new DrawnNumbers(winningNumbers, bonusNumber);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(drawnNumbers);
        WinningResult winningResult = lottoResultChecker.check(lottos);

        // when
        int totalPrize = winningResult.calculateTotalPrize();

        // then
        assertThat(totalPrize).isEqualTo(2000005000);
    }
}