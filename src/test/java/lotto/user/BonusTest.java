package lotto.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.system.utils.constants.LottoConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    @DisplayName("유효한 보너스 번호 생성 테스트")
    @Test
    void createValidBonusNumber() {
        // given
        int bonusNumber = 7;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Bonus bonus = new Bonus(bonusNumber, winningNumbers);

        // then
        assertThat(bonus).isNotNull();
        assertThat(bonus.getNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("보너스 번호가 범위를 벗어날 때 예외 발생 테스트")
    @Test
    void bonusNumberOutOfRangeThrowsException() {
        // given
        int invalidBonusNumber = LottoConstants.LOTTO_NUMBER_UPPER_BOUND + 1;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // then
        assertThatThrownBy(() -> new Bonus(invalidBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format("[ERROR] 번호는 %d부터 %d사이의 숫자여야 합니다.",
                                LottoConstants.LOTTO_NUMBER_LOWER_BOUND,
                                LottoConstants.LOTTO_NUMBER_UPPER_BOUND
                        )
                );
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생 테스트")
    @Test
    void duplicateBonusNumberThrowsException() {
        // given
        int duplicateBonusNumber = 3;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // then
        assertThatThrownBy(() -> new Bonus(duplicateBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }
}