package lotto.model;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 객체 만들기 성공")
    void 로또_객체_만들기_성공() {
        // given
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

        // when

        // then
        assertDoesNotThrow(() -> new Lotto(nums));
    }

    @Test
    @DisplayName("로또 번호 중 중복이 있는 경우 예외")
    void 로또_번호가_중복이_있는_경우_예외() {
        // given
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 5);

        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Lotto(nums));

        // given
        assertEquals(ErrorMessage.EXIST_NUM.getMessage(), e.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닌 경우")
    void 로또_번호가_여섯개가_아닌_경우_예외() {
        // given
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Lotto(nums));

        // given
        assertEquals(ErrorMessage.NOT_SIX_NUM.getMessage(), e.getMessage());
    }

    @Test
    @DisplayName("로또 번호 중 1~45가 아닌 경우 예외")
    void 로또_번호가_범위안이_아닌_경우_예외() {
        // given
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 100);

        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Lotto(nums));

        // given
        assertEquals(ErrorMessage.NOT_IN_RANGE.getMessage(), e.getMessage());
    }

    @Test
    @DisplayName("로또 1등인 경우")
    void 로또_1등인_경우() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winnerNums = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        Rank rank = lotto.getRank(winnerNums, bonus);

        // then
        assertEquals(Rank.FIRST, rank);
    }

    @Test
    @DisplayName("로또 2등인 경우")
    void 로또_2등인_경우() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winnerNums = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        Rank rank = lotto.getRank(winnerNums, bonus);

        // then
        assertEquals(Rank.SECOND, rank);
    }

    @Test
    @DisplayName("로또 3등인 경우")
    void 로또_3등인_경우() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<Integer> winnerNums = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        Rank rank = lotto.getRank(winnerNums, bonus);

        // then
        assertEquals(Rank.THIRD, rank);
    }

    @Test
    @DisplayName("로또 4등인 경우")
    void 로또_4등인_경우() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 7));
        List<Integer> winnerNums = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        Rank rank = lotto.getRank(winnerNums, bonus);

        // then
        assertEquals(Rank.FOURTH, rank);
    }

    @Test
    @DisplayName("로또 5등인 경우")
    void 로또_5등인_경우() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        List<Integer> winnerNums = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        Rank rank = lotto.getRank(winnerNums, bonus);

        // then
        assertEquals(Rank.FIFTH, rank);
    }

    @Test
    @DisplayName("로또 꽝인 경우")
    void 로또_꽝등인_경우() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 10, 11, 12, 13));
        List<Integer> winnerNums = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        Rank rank = lotto.getRank(winnerNums, bonus);

        // then
        assertEquals(Rank.NO_LUCK, rank);
    }
}
