package lotto.domain.lotto;

import static lotto.support.utils.CustomExceptionAssertions.assertCustomIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.quantity.Quantity;
import lotto.exception.argument.lotto.InvalidLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 테스트")
class LottoTest {

    @Nested
    @DisplayName("로또 수동 생성 테스트")
    class 로또_수동_생성_테스트 {

        @Test
        @DisplayName("로또를 생성한다.")
        void 성공_수동생성() {
            // Given

            // When
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            // Then
            assertThat(lotto.getNumbers()).extracting("numbers").isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        }

        @Test
        @DisplayName("생성시 로또 번호는 정렬되어 저장된다.")
        void 성공_수동생성_정렬() {
            // Given

            // When
            Lotto lotto = new Lotto(List.of(1, 11, 3, 4, 10, 6));

            // Then
            assertThat(lotto.getNumbers()).extracting("numbers").isEqualTo(List.of(1, 3, 4, 6, 10, 11));
        }

        @ParameterizedTest
        @MethodSource
        @DisplayName("로또 번호가 6개가 아닌 경우 예외가 발생한다.")
        void 실패_수동생성_6개X(List<Integer> numbers) {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(() -> new Lotto(numbers))
                    .isExactlyInstanceOf(InvalidLottoException.class)
                    .hasMessageContaining("로또는 중복되지 않은 6개의 숫자여야 합니다.");
        }

        private static Stream<Arguments> 실패_수동생성_6개X() {
            return Stream.of(
                    Arguments.of(List.of(1)),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
            );
        }

        @Test
        @DisplayName("로또 번호가 중복될 경우 예외가 발생한다.")
        void 실패_수동생성_중복() {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isExactlyInstanceOf(InvalidLottoException.class)
                    .hasMessageContaining("로또는 중복되지 않은 6개의 숫자여야 합니다.");
        }
    }

    @Nested
    @DisplayName("로또 다중 생성 테스트")
    class 로또_다중_생성_테스트 {

        @Test
        @DisplayName("로또를 여러개 생성한다.")
        void 성공_생성() {
            // Given

            // When
            List<Lotto> lottos = Lotto.createMultipleLottos(new Quantity(BigDecimal.TWO));

            // Then
            assertAll(
                    () -> assertThat(lottos.size()).isEqualTo(2),
                    () -> assertThat(lottos).allMatch(lotto -> lotto.getNumbers().numbers().size() == 6)
            );
        }
    }

    @Nested
    @DisplayName("포함 확인 테스트")
    class 포함_확인_테스트 {

        @ParameterizedTest
        @CsvSource({"1,true", "7,false"})
        @DisplayName("로또 번호가 로또에 포함되는지 확인한다.")
        void 성공_포함확인(int number, boolean contains) {
            // Given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber lottoNumber = LottoNumber.valueOf(number);

            // When & Then
            assertThat(lotto.contains(lottoNumber)).isEqualTo(contains);
        }
    }

    @Nested
    @DisplayName("두 로또 일치 개수 세기 테스트")
    class 두_로또_일치개수_테스트 {

        @Test
        @DisplayName("일치 개수를 센다.")
        void 성공_일치개수() {
            // Given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));

            // When
            int count = lotto.countMatchingNumber(winningLotto);

            // Then
            assertThat(count).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("로또와 로또 번호 일치 개수 세기 테스트")
    class 로또_로또번호_일치개수_테스트 {

        @ParameterizedTest
        @CsvSource({"1,true", "7,false"})
        @DisplayName("일치 개수를 센다.")
        void 성공_일치개수(int number, boolean expected) {
            // Given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber lottoNumber = LottoNumber.valueOf(number);

            // When
            boolean doesMatch = lotto.doesMatchBonusNumber(lottoNumber);

            // Then
            assertThat(doesMatch).isEqualTo(expected);
        }
    }
}
