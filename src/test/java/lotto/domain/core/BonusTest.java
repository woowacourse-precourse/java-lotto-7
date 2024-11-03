package lotto.domain.core;

import static lotto.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class BonusTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("유효한 보너스 번호가 주어졌을 때 보너스 객체가 정상적으로 생성된다.")
        public void 유효한_보너스_번호_생성_성공() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Bonus bonus = new Bonus(7, lotto);
            assertThat(bonus.getNumber()).isEqualTo(7);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @ParameterizedTest
        @ValueSource(ints = {0, 46, -1})
        @DisplayName("보너스 번호가 1~45 범위를 벗어난 경우 예외가 발생한다.")
        public void 보너스_번호_범위_예외(int invalidNumber) {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            assertThatThrownBy(() -> new Bonus(invalidNumber, lotto))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_NUMBER_RANGE.getMessage());
        }

        @Test
        @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
        public void 보너스_번호_중복_예외() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            assertThatThrownBy(() -> new Bonus(1, lotto))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage(DUPLICATE_NUMBER.getMessage());
        }
    }
}
