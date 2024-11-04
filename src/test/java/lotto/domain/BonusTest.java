package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.config.LottoConstants;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("유효한 보너스 번호 생성 테스트")
    @Test
    void createValidBonusNumber() {
        // when
        int bonusNumber = 7;
        Bonus bonus = new Bonus(bonusNumber, lotto.getNumbers());

        // then
        assertThat(bonus.getNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("보너스 번호가 범위를 벗어날 때 예외 발생 테스트")
    @Test
    void bonusNumberOutOfRangeThrowsException() {
        // given
        int outOfRangeBonusNumber = LottoConstants.LOTTO_NUMBER_UPPER_BOUND + 1;

        // then
        assertThatThrownBy(() -> new Bonus(outOfRangeBonusNumber, lotto.getNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생 테스트")
    @Test
    void duplicateBonusNumberThrowsException() {
        // given
        int duplicateBonusNumber = 1;

        // then
        assertThatThrownBy(() -> new Bonus(duplicateBonusNumber, lotto.getNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}