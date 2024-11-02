package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("로또 시스템 테스트")
public class LotteryTest {

    @Nested
    @DisplayName("생성 테스트")
    class 생성_테스트 {

        @Test
        @DisplayName("로또 당첨 번호와 보너스 번호를 입력받아 로또 시스템을 만든다")
        void 성공_생성() {
            // Given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber bonusNumber = new LottoNumber(10);

            // When & Then
            assertThatCode(() -> {
                new Lottery(lotto, bonusNumber);
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("보너스 번호가 발행한 로또에 포함되면 예외가 발생한다")
        void 실패_생성() {
            // Given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber bonusNumber = new LottoNumber(1);

            // When & Then
            assertThatThrownBy(() -> new Lottery(lotto, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidLottoNumberException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("보너스 번호가 로또에 포함되어서는 안됩니다");
        }
    }
}
