package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoAnswer;
import lotto.model.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatcherTest {

    @Test
    @DisplayName("1등 당첨 테스트")
    void matchFirstTest() {
        // given
        final List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;
        final WinningResult expected = WinningResult.FIRST;

        // when
        final WinningResult result = LottoMatcher.match(userLotto, winningLotto, bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("2등 당첨 테스트")
    void matchSecondTest() {
        // given
        final List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 7);
        final int bonusNumber = 6;
        final WinningResult expected = WinningResult.SECOND;

        // when
        final WinningResult result = LottoMatcher.match(userLotto, winningLotto, bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("3등 당첨 테스트")
    void matchThirdTest() {
        // given
        final List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 7);
        final int bonusNumber = 8;
        final WinningResult expected = WinningResult.THIRD;

        // when
        final WinningResult result = LottoMatcher.match(userLotto, winningLotto, bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("4등 당첨 테스트 - 보너스 번호 일치X")
    void matchFourthTest_noBonus() {
        // given
        final List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningLotto = List.of(1, 2, 3, 4, 7, 8);
        final int bonusNumber = 9;
        final WinningResult expected = WinningResult.FOURTH;

        // when
        final WinningResult result = LottoMatcher.match(userLotto, winningLotto, bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("4등 당첨 테스트 - 보너스 번호 일치")
    void matchFourthTest_withBonus() {
        // given
        final List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningLotto = List.of(1, 2, 3, 4, 7, 8);
        final int bonusNumber = 5;
        final WinningResult expected = WinningResult.FOURTH;

        // when
        final WinningResult result = LottoMatcher.match(userLotto, winningLotto, bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("5등 당첨 테스트 - 보너스 번호 일치X")
    void matchFifthTest_noBonus() {
        // given
        final List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningLotto = List.of(1, 2, 3, 7, 8, 9);
        final int bonusNumber = 10;
        final WinningResult expected = WinningResult.FIFTH;

        // when
        final WinningResult result = LottoMatcher.match(userLotto, winningLotto, bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("5등 당첨 테스트 - 보너스 번호 일치")
    void matchFifthTest_withBonus() {
        // given
        final List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningLotto = List.of(1, 2, 3, 7, 8, 9);
        final int bonusNumber = 6;
        final WinningResult expected = WinningResult.FIFTH;

        // when
        final WinningResult result = LottoMatcher.match(userLotto, winningLotto, bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("꽝 당첨 테스트 - 보너스 번호 일치")
    void matchNoneTest_withBonus() {
        // given
        final List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningLotto = List.of(1, 2, 7, 8, 9, 10);
        final int bonusNumber = 3;
        final WinningResult expected = WinningResult.NONE;

        // when
        final WinningResult result = LottoMatcher.match(userLotto, winningLotto, bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("꽝 당첨 테스트 - 보너스 번호 불일치")
    void matchNoneTest_noBonus() {
        // given
        final List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningLotto = List.of(1, 2, 7, 8, 9, 10);
        final int bonusNumber = 11;
        final WinningResult expected = WinningResult.NONE;

        // when
        final WinningResult result = LottoMatcher.match(userLotto, winningLotto, bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Lotto와 LottoAnswer클래스 비교 테스트 - 1등")
    void matchFirstTest_class() {
        // given
        List<Integer> userLottoNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningLottoNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        final int bonusNumber = 7;
        final WinningResult expected = WinningResult.FIRST;

        var userLotto = new Lotto(userLottoNumber);
        var winningLotto = new LottoAnswer(winningLottoNumber, bonusNumber);
        // when
        final WinningResult result = LottoMatcher.match(userLotto, winningLotto);

        // then
        assertThat(result).isEqualTo(expected);
    }
}