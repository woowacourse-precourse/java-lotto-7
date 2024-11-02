package lotto.model;

import static lotto.constant.ErrorMessage.DUPLICATED_BONUS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("== WinningLotto 테스트 ==")
public class WinningLottoTest {
    @Nested
    @DisplayName("-- 기능 테스트 --")
    class FeatureTest {
        // WinningLotto는 내부적으로 Lotto의 메서드를 사용하고 있어 Lotto 단위 테스트로 대체
    }

    @Nested
    @DisplayName("-- 예외 테스트 --")
    class ExceptionTest {
        @ParameterizedTest
        @DisplayName("당첨 번호와 보너스 번호가 중복됨")
        @MethodSource("duplicatedLottoAndBonusArguments")
        void 당첨_번호와_보너스_번호_중복됨(Lotto lotto, int bonusNumber) {
            assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DUPLICATED_BONUS.getMessage());
        }

        static Stream<Arguments> duplicatedLottoAndBonusArguments() {
            return Stream.of(
                    Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 1),
                    Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 3),
                    Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                    Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 45)), 45)
            );
        }
    }
}
