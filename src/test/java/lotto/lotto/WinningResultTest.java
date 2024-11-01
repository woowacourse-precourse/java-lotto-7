package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.EnumMap;
import java.util.List;
import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 예외가 발생한다")
    @Test
    void newWinningResultWithDuplicateBonusNumber() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        Number duplicateBonusNumber = new Number(3);

        assertThatThrownBy(() -> new WinningResult(winningNumbers, duplicateBonusNumber))
                .isInstanceOf(CustomException.class)
                .hasMessage("[ERROR] " + ExceptionMessage.DUPLICATE_BONUS_NUMBER.getMessage());
    }

    @DisplayName("당첨 결과가 정확히 계산된다")
    @Test
    void calculateResultCorrect() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        Number bonusNumber = new Number(7);
        WinningResult winningResult = new WinningResult(winningNumbers, bonusNumber);

        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));

        winningResult.calculateResult(lottos);
        EnumMap<Rank, Integer> rankCounts = winningResult.getRankCounts();

        assertThat(rankCounts.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.THIRD)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.NONE)).isEqualTo(1);
    }
}