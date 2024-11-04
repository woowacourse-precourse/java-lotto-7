package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberValidatorTest {
    @Nested
    @DisplayName("로또 번호 개수 검증")
    class ValidateSize {
        @Test
        @DisplayName("로또 번호가 6개인 경우 정상 처리한다.")
        void 로또_번호가_6개인_경우_정상_처리한다() {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

            assertThatNoException()
                    .isThrownBy(() -> LottoNumberValidator.validateSize(numbers));
        }

        @Test
        @DisplayName("로또 번호가 6개가 아닌 경우 예외가 발생한다.")
        void 로또_번호가_6개가_아닌_경우_예외가_발생한다() {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

            assertThatThrownBy(() -> LottoNumberValidator.validateSize(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("6개");
        }
    }

    @Nested
    @DisplayName("로또 번호 중복 검증")
    class ValidateDuplicates {
        @Test
        @DisplayName("중복되지 않은 번호들은 정상 처리한다.")
        void 중복되지_않은_번호들은_정상_처리한다() {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

            assertThatNoException()
                    .isThrownBy(() -> LottoNumberValidator.validateDuplicates(numbers));
        }

        @Test
        @DisplayName("중복된 번호가 있으면 예외가 발생한다.")
        void 중복된_번호가_있으면_예외가_발생한다() {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5);

            assertThatThrownBy(() -> LottoNumberValidator.validateDuplicates(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("중복");
        }
    }

    @Nested
    @DisplayName("로또 번호들의 범위 검증")
    class ValidateNumbersInRange {
        @Test
        @DisplayName("모든 번호가 범위 내에 있으면 정상 처리한다.")
        void 모든_번호가_범위_내에_있으면_정상_처리한다() {
            List<Integer> numbers = Arrays.asList(1, 20, 30, 40, 44, 45);

            assertThatNoException()
                    .isThrownBy(() -> LottoNumberValidator.validateNumbersInRange(numbers));
        }

        @Test
        @DisplayName("범위를 벗어난 번호가 있으면 예외가 발생한다.")
        void 범위를_벗어난_번호가_있으면_예외가_발생한다() {
            List<Integer> numbers = Arrays.asList(1, 20, 30, 40, 45, 46);

            assertThatThrownBy(() -> LottoNumberValidator.validateNumbersInRange(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이하");
        }
    }
}
