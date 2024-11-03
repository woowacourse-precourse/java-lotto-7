package lotto.domain.winning;

import static lotto.exception.message.WinningNumberExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.exception.message.WinningNumberExceptionMessage.DUPLICATE_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

    WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        winningNumber = new WinningNumber(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                LottoNumber.from(7)
        );
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void givenDuplicatedBonusNumber_whenCreate_thenThrowsException1() {
        // given
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(6);

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("모두 다 일치한 로또 번호가 주어질 경우, 1등이다.")
    void givenLottoWithAllMatchingNumbers_whenMatch_thenReturnFirstRank() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoRank result = winningNumber.match(lotto);

        // then
        assertThat(result).isEqualTo(LottoRank.PRIZE_FIRST);
    }

    @Test
    @DisplayName("5개의 로또 번호와 보너스 번호가 일치하다면, 2등이다.")
    void givenLottoWithFiveMatchingNumbersAndBonusNumber_whenMatch_thenReturnSecondRank() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 7));

        // when
        LottoRank result = winningNumber.match(lotto);

        // then
        assertThat(result).isEqualTo(LottoRank.PRIZE_SECOND);
    }

    @Test
    @DisplayName("5개의 로또 번호가 일치하다면, 3등이다.")
    void givenLottoWithFiveMatchingNumbers_whenMatch_thenReturnThirdRank() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 8));

        // when
        LottoRank result = winningNumber.match(lotto);

        // then
        assertThat(result).isEqualTo(LottoRank.PRIZE_THIRD);
    }

    @Test
    @DisplayName("4개의 로또 번호가 일치하다면, 4등이다.")
    void givenLottoWithFourMatchingNumbers_whenMatch_thenReturnFourthRank() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 7, 8));

        // when
        LottoRank result = winningNumber.match(lotto);

        // then
        assertThat(result).isEqualTo(LottoRank.PRIZE_FOURTH);
    }

    @Test
    @DisplayName("3개의 로또 번호가 일치하다면, 5등이다.")
    void givenLottoWithThreeMatchingNumbers_whenMatch_thenReturnFifthRank() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 9, 7, 8));

        // when
        LottoRank result = winningNumber.match(lotto);

        // then
        assertThat(result).isEqualTo(LottoRank.PRIZE_FIFTH);
    }

    @Test
    @DisplayName("2개부터는 꼴등이다.")
    void givenLottoWithThreeMatchingNumbers_whenMatch_thenReturnLastRank() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 10, 9, 7, 8));

        // when
        LottoRank result = winningNumber.match(lotto);

        // then
        assertThat(result).isEqualTo(LottoRank.NONE);
    }

}