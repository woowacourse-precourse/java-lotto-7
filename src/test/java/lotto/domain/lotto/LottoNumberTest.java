package lotto.domain.lotto;

import static lotto.support.utils.CustomExceptionAssertions.assertCustomIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatCode;

import lotto.exception.argument.lotto.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 번호 테스트")
public class LottoNumberTest {

    @Nested
    @DisplayName("생성 테스트 - 정수")
    class 생성_테스트_정수 {

        @Test
        @DisplayName("로또 번호를 생성한다.")
        void 성공_생성() {
            // Given

            // When & Then
            assertThatCode(() -> {
                LottoNumber.valueOf(1);
            }).doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 46})
        @DisplayName("로또 번호가 1 이상 45 이하가 아니면 예외가 발생한다.")
        void 실패_생성_범위X(int number) {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(() -> LottoNumber.valueOf(number))
                    .isExactlyInstanceOf(InvalidLottoNumberException.class)
                    .hasMessageContaining("로또 번호는 1 이상 45 이하여야 합니다.");
        }
    }
}
