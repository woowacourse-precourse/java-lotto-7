package lotto.domain;

import java.util.Arrays;
import lotto.global.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void validateDuplicateBonusNumber() {
        // given
        Lotto mainNumbers = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(1);

        // when & then
        assertThatThrownBy(() -> WinningNumbers.of(mainNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_BONUS_NUMBER);
    }

    @DisplayName("당첨 번호와 일치하는 번호의 개수를 계산한다.")
    @Test
    void countMatchNumbers() {
        // given
        Lotto mainNumbers = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(7);
        WinningNumbers winningNumbers = WinningNumbers.of(mainNumbers, bonusNumber);
        Lotto userLotto = Lotto.from(Arrays.asList(1, 2, 3, 7, 8, 9));

        // when
        int matchCount = winningNumbers.countMatchNumbers(userLotto);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("보너스 번호 일치 여부를 확인한다.")
    @Test
    void checkBonusNumberMatch() {
        // given
        Lotto mainNumbers = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(7);
        WinningNumbers winningNumbers = WinningNumbers.of(mainNumbers, bonusNumber);
        Lotto userLotto = Lotto.from(Arrays.asList(1, 2, 3, 7, 8, 9));

        // when
        boolean matchBonus = winningNumbers.matchBonus(userLotto);

        // then
        assertThat(matchBonus).isTrue();
    }
}