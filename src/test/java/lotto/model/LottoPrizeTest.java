package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {

    @DisplayName("당첨 번호 6개 일치, First를 반환한다.")
    @Test
    void Given_WinningCountSix_When_matchPrize_Then_First() {
        // Given
        int winningCount = 6;
        int bonusCount = 0;
        // When
        LottoPrize lottoPrize = LottoPrize.matchPrize(winningCount, bonusCount);
        // Then
        assertThat(lottoPrize).isEqualTo(LottoPrize.FIRST_PRIZE);
    }

    @DisplayName("당첨 번호 5개 일치, 보너스 1개 일치일경우, Second를 반환한다.")
    @Test
    void Given_WinningCountFiveBonus_When_matchPrize_Then_Second() {
        // Given
        int winningCount = 5;
        int bonusCount = 1;
        // When
        LottoPrize lottoPrize = LottoPrize.matchPrize(winningCount, bonusCount);
        // Then
        assertThat(lottoPrize).isEqualTo(LottoPrize.SECOND_PRIZE);
    }

    @DisplayName("당첨 번호 5개 일치, 보너스 0개 일치일경우, Third를 반환한다.")
    @Test
    void Given_WinningCountFive_When_matchPrize_Then_Third() {
        // Given
        int winningCount = 5;
        int bonusCount = 0;
        // When
        LottoPrize lottoPrize = LottoPrize.matchPrize(winningCount, bonusCount);
        // Then
        assertThat(lottoPrize).isEqualTo(LottoPrize.THIRD_PRIZE);
    }

    @DisplayName("당첨 번호 4개 일치, 보너스 0개 일치일경우, Forth를 반환한다.")
    @Test
    void Given_WinningCountFour_When_matchPrize_Then_Forth() {
        // Given
        int winningCount = 4;
        int bonusCount = 0;
        // When
        LottoPrize lottoPrize = LottoPrize.matchPrize(winningCount, bonusCount);
        // Then
        assertThat(lottoPrize).isEqualTo(LottoPrize.FORTH_PRIZE);
    }

    @DisplayName("당첨 번호 3개 일치, 보너스 0개 일치일경우, Fifth를 반환한다.")
    @Test
    void Given_WinningCountThree_When_matchPrize_Then_Fifth() {
        // Given
        int winningCount = 3;
        int bonusCount = 0;
        // When
        LottoPrize lottoPrize = LottoPrize.matchPrize(winningCount, bonusCount);
        // Then
        assertThat(lottoPrize).isEqualTo(LottoPrize.FIFTH_PRIZE);
    }
}