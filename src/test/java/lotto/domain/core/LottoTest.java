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

class LottoTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("6개의 고유한 숫자(1~45 범위)로 생성된 로또가 정상적으로 생성된다.")
        public void 로또_생성_성공() {
            List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
            Lotto lotto = new Lotto(validNumbers);
            assertThat(lotto.getNumbers()).containsExactlyElementsOf(validNumbers);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
        void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_SIZE.getMessage());
        }

        @Test
        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage(DUPLICATE_NUMBER.getMessage());
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 46})
        @DisplayName("로또 번호가 1~45 범위를 벗어난 경우 예외가 발생한다.")
        public void 번호_범위_예외(int invalidNumber) {
            List<Integer> outOfRangeNumbers = List.of(1, 2, 3, 4, 5, invalidNumber);
            assertThatThrownBy(() -> new Lotto(outOfRangeNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
