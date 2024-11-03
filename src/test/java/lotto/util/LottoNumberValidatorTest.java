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
}
