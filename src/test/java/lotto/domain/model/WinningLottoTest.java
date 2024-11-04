package lotto.domain.model;

import lotto.domain.model.LottoNumbers;
import lotto.domain.model.LottoRank;
import lotto.domain.model.WinningLotto;
import lotto.util.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class WinningLottoTest {

    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외가 발생한다.")
    @Test
    void shouldThrowExceptionWhenBonusNumberIsDuplicatedWithWinningNumbers() {
        LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 3;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATE_BONUS_NUMBER);
    }

    @DisplayName("사용자 번호와 일치하는 개수와 보너스 여부에 따라 올바른 등수를 반환한다.")
    @Test
    void shouldReturnCorrectRankBasedOnMatchingNumbersAndBonus() {
        LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // 6개 일치
        LottoNumbers userLottoNumbers1 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.calculateRank(userLottoNumbers1)).isEqualTo(LottoRank.FIRST);

        // 5개 일치 + 보너스
        LottoNumbers userLottoNumbers2 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.calculateRank(userLottoNumbers2)).isEqualTo(LottoRank.SECOND);

        // 5개 일치
        LottoNumbers userLottoNumbers3 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 8));
        assertThat(winningLotto.calculateRank(userLottoNumbers3)).isEqualTo(LottoRank.THIRD);

        // 4개 일치
        LottoNumbers userLottoNumbers4 = new LottoNumbers(List.of(1, 2, 3, 4, 9, 10));
        assertThat(winningLotto.calculateRank(userLottoNumbers4)).isEqualTo(LottoRank.FOURTH);

        // 3개 일치
        LottoNumbers userLottoNumbers5 = new LottoNumbers(List.of(1, 2, 3, 11, 12, 13));
        assertThat(winningLotto.calculateRank(userLottoNumbers5)).isEqualTo(LottoRank.FIFTH);

        // 2개 이하 일치 (낙첨)
        LottoNumbers userLottoNumbers6 = new LottoNumbers(List.of(1, 2, 14, 15, 16, 17));
        assertThat(winningLotto.calculateRank(userLottoNumbers6)).isEqualTo(LottoRank.NONE);
    }
}
