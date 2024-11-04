package lotto.domain.lotto;

import static lotto.support.utils.CustomExceptionAssertions.assertCustomIllegalArgumentException;
import static lotto.support.utils.CustomExceptionAssertions.assertCustomIllegalStateException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import lotto.exception.state.InvalidStateException;
import lotto.exception.argument.lotto.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("로또 시스템 테스트")
public class LotteryTest {

    @Nested
    @DisplayName("생성 테스트")
    class 생성_테스트 {

        @Test
        @DisplayName("로또 당첨 번호와 보너스 번호를 입력받아 로또 시스템을 만든다.")
        void 성공_생성() {
            // Given
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber bonusNumber = LottoNumber.valueOf(10);
            List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

            // When & Then
            assertThatCode(() -> {
                new Lottery(winningLotto, bonusNumber, lottos);
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("보너스 번호가 발행한 로또에 포함되면 예외가 발생한다.")
        void 실패_생성_포함() {
            // Given
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber bonusNumber = LottoNumber.valueOf(1);
            List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

            // When & Then
            assertCustomIllegalArgumentException(() -> new Lottery(winningLotto, bonusNumber, lottos))
                    .isExactlyInstanceOf(InvalidLottoNumberException.class)
                    .hasMessageContaining("보너스 번호가 로또에 포함되어서는 안됩니다.");
        }
    }

    @Nested
    @DisplayName("당첨 내역 테스트")
    class 당첨_내역_테스트 {

        @Test
        @DisplayName("당첨 내역을 계산한다.")
        void 성공_계산() {
            // Given
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber bonusNumber = LottoNumber.valueOf(10);
            List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(1, 2, 3, 4, 5, 10)));
            Lottery lottery = new Lottery(winningLotto, bonusNumber, lottos);

            // When
            BigDecimal firstCount = lottery.get(LottoRank.FIRST);
            BigDecimal secondCount = lottery.get(LottoRank.SECOND);

            // Then
            assertAll(
                    () -> assertThat(firstCount).isEqualTo(BigDecimal.ONE),
                    () -> assertThat(secondCount).isEqualTo(BigDecimal.ONE)
            );
        }
    }

    @Nested
    @DisplayName("수익률 계산 테스트")
    class 수익률_계산_테스트 {

        @Test
        @DisplayName("수익률을 계산한다.")
        void 성공_계산() {
            // Given
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber bonusNumber = LottoNumber.valueOf(10);
            List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(1, 2, 3, 4, 5, 10)));
            Lottery lottery = new Lottery(winningLotto, bonusNumber, lottos);

            // When
            BigDecimal profitRate = lottery.calculateProfitRate();

            // Then
            assertThat(profitRate).isEqualTo(new BigDecimal("101500000.0"));
        }

        @Test
        @DisplayName("구매한 로또가 없을 경우 예외가 발생한다.")
        void 실패_계산_구매로또X() {
            // Given
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber bonusNumber = LottoNumber.valueOf(10);
            List<Lotto> lottos = Collections.emptyList();
            Lottery lottery = new Lottery(winningLotto, bonusNumber, lottos);

            // When & Then
            assertCustomIllegalStateException(lottery::calculateProfitRate)
                    .isExactlyInstanceOf(InvalidStateException.class)
                    .hasMessageContaining("구매한 로또가 없습니다.");
        }
    }
}
