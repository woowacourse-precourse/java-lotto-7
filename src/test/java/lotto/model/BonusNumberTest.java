package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.controller.error.ErrorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("보너스 번호가 적절한 값이라면 생성된다.")
        void createBonusNumber() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int number = 7;

            // when
            BonusNumber bonusNumber = new BonusNumber(number, lotto);

            // then
            assertThat(bonusNumber.getNumber()).isEqualTo(number);
        }

        @Test
        @DisplayName("문자열로 주어진 보너스 번호로도 생성된다.")
        void createBonusNumberFromString() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            String number = "7";

            // when
            BonusNumber bonusNumber = BonusNumber.of(number, lotto);

            // then
            assertThat(bonusNumber.getNumber()).isEqualTo(7);
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
        void bonusNumberDuplicate() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int duplicateBonusNumber = 6;

            // when & then
            assertThatThrownBy(() -> new BonusNumber(duplicateBonusNumber, lotto))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorType.DUPLICATE_NUMBER.getMessage());
        }

        @Test
        @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
        void bonusNumberOutOfRange() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int outOfRangeBonusNumber = Lotto.MAX_LOTTO_NUMBER + 1;

            // when & then
            assertThatThrownBy(() -> new BonusNumber(outOfRangeBonusNumber, lotto))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorType.OUT_OF_RANGE.getMessage());
        }

        @Test
        @DisplayName("보너스 번호가 유효하지 않은 문자열이면 예외가 발생한다.")
        void bonusNumberInvalidFormat() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            String invalidBonusNumber = "abc";

            // when & then
            assertThatThrownBy(() -> BonusNumber.of(invalidBonusNumber, lotto))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorType.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
