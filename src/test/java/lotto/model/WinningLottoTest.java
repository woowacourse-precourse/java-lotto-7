package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("사용자 로또와 당첨 로또의 일치하는 숫자 개수를 올바르게 계산한다.")
        void matchCount() {
            // given
            Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7, winningLottoNumbers);
            WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

            Lotto userLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));

            // when
            int matchCount = winningLotto.matchCount(userLotto);

            // then
            assertThat(matchCount).isEqualTo(3);
        }

        @Test
        @DisplayName("사용자 로또가 보너스 번호와 일치할 경우 올바르게 반환한다.")
        void matchBonus() {
            // given
            Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7, winningLottoNumbers);
            WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

            Lotto userLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));

            // when
            boolean isBonusMatched = winningLotto.matchBonus(userLotto);

            // then
            assertThat(isBonusMatched).isTrue();
        }

        @Test
        @DisplayName("사용자 로또가 보너스 번호와 일치하지 않을 경우 올바르게 반환한다.")
        void noMatchBonus() {
            // given
            Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7, winningLottoNumbers);
            WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

            Lotto userLotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));

            // when
            boolean isBonusMatched = winningLotto.matchBonus(userLotto);

            // then
            assertThat(isBonusMatched).isFalse();
        }
    }
}
