package lotto.model.draw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import lotto.model.lotto.Lotto;
import lotto.util.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoDrawTest {

    private Lotto lotto;
    private Bonus bonus;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonus = new Bonus(7);
    }

    @Nested
    @DisplayName("LottoDraw 생성 테스트")
    class LottoDrawCreationTests {

        @Test
        @DisplayName("당첨 번호와 보너스 번호가 중복되지 않으면 정상적으로 생성된다")
        void createLottoDrawSuccessfully() {
            LottoDraw lottoDraw = LottoDraw.by(lotto, bonus);

            assertThat(lottoDraw.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
            assertThat(lottoDraw.getBonusNumber()).isEqualTo(7);
        }

        @Test
        @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
        void createLottoDrawWithDuplicateBonusThrowsException() {
            Bonus duplicateBonus = new Bonus(6);

            assertThatThrownBy(() -> LottoDraw.by(lotto, duplicateBonus))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

    @Nested
    @DisplayName("LottoDraw 메서드 테스트")
    class LottoDrawMethodsTests {

        @Test
        @DisplayName("getWinningNumbers 메서드는 당첨 번호를 반환한다")
        void getWinningNumbers() {
            LottoDraw lottoDraw = LottoDraw.by(lotto, bonus);

            List<Integer> winningNumbers = lottoDraw.getWinningNumbers();
            assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
        }

        @Test
        @DisplayName("getBonusNumber 메서드는 보너스 번호를 반환한다")
        void getBonusNumber() {
            LottoDraw lottoDraw = LottoDraw.by(lotto, bonus);

            int bonusNumber = lottoDraw.getBonusNumber();
            assertThat(bonusNumber).isEqualTo(7);
        }
    }
}