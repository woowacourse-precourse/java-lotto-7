package lotto.domain.lottoMachine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @Nested
    class BonusNumber_검증_테스트 {

        @ParameterizedTest
        @ValueSource(strings = {"0", "46"})
        void 보너스_번호가_범위를_벗어나면_예외가_발생한다(String numbers) {
            assertThatThrownBy(() -> BonusNumber.from(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
            assertThatThrownBy(() -> BonusNumber.from("a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
