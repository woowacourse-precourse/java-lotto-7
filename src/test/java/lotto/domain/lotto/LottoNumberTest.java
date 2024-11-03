package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.lotto.InvalidLottoNumberException;
import lotto.support.converter.IntegerConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 번호 테스트")
public class LottoNumberTest {

    @Nested
    @DisplayName("생성 테스트 - 문자열")
    class 생성_테스트_문자열 {

        @Test
        @DisplayName("로또 번호를 생성한다")
        void 성공_생성() {
            // Given
            IntegerConverter converter = new IntegerConverter();

            // When & Then
            assertThatCode(() -> {
                LottoNumber.from("1", converter);
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("비어있을 경우 실패한다")
        void 실패_생성_비어있음() {
            // Given
            IntegerConverter converter = new IntegerConverter();

            // When & Then
            assertThatThrownBy(() -> LottoNumber.from("", converter))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidLottoNumberException.class)
                    .hasMessageContaining("로또 번호는 비어있거나 공백일 수 없습니다");
        }

        @Test
        @DisplayName("공백일 경우 실패한다")
        void 실패_생성_공백() {
            // Given
            IntegerConverter converter = new IntegerConverter();

            // When & Then
            assertThatThrownBy(() -> LottoNumber.from(" ", converter))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidLottoNumberException.class)
                    .hasMessageContaining("로또 번호는 비어있거나 공백일 수 없습니다");
        }

        @Test
        @DisplayName("null일 경우 실패한다")
        void 실패_생성_null() {
            // Given
            IntegerConverter converter = new IntegerConverter();

            // When & Then
            assertThatThrownBy(() -> LottoNumber.from(null, converter))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidLottoNumberException.class)
                    .hasMessageContaining("로또 번호는 null일 수 없습니다");
        }
    }

    @Nested
    @DisplayName("생성 테스트 - 정수")
    class 생성_테스트_정수 {

        @Test
        @DisplayName("로또 번호를 생성한다")
        void 성공_생성() {
            // Given

            // When & Then
            assertThatCode(() -> {
                new LottoNumber(1);
            }).doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 46})
        @DisplayName("로또 번호가 1 이상 45 이하가 아니면 예외가 발생한다")
        void 실패_생성_범위X(int number) {
            // Given

            // When & Then
            assertThatThrownBy(() -> new LottoNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidLottoNumberException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("로또 번호는 1 이상 45 이하여야 합니다");
        }
    }
}
