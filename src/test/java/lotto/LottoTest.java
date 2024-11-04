package lotto;

import Rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    /*
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }*/
    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    void testCalculateWinningResults_withAllMatches() {
        List<List<Integer>> lottoTickets = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> result = Lotto.calculateWinningResults(lottoTickets, winNumber, bonusNumber);

        // 1등: 2개
        assertEquals(2, result.get(Rank.FIRST));
        // 2등: 0개
        assertEquals(0, result.get(Rank.SECOND));
    }
    @Test
    void testCalculateWinningResults_withBonusMatch1() {
        List<List<Integer>> lottoTickets = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),  // 1등
                Arrays.asList(1, 2, 3, 4, 5, 7)   // 2등
        );
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> result = Lotto.calculateWinningResults(lottoTickets, winNumber, bonusNumber);
        System.out.println("Result: " + result);
        // 1등: 1개
        assertEquals(1, result.get(Rank.FIRST));
        // 2등: 1개
        assertEquals(1, result.get(Rank.SECOND));
    }
    @Test
    void testCalculateWinningResults_withBonusMatch() {
        List<List<Integer>> lottoTickets = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 7)
        );
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> result = Lotto.calculateWinningResults(lottoTickets, winNumber, bonusNumber);

        // 1등: 1개
        assertEquals(1, result.get(Rank.FIRST));
        // 2등: 1개
        assertEquals(1, result.get(Rank.SECOND));
    }

    @Test
    void testCalculateWinningResults_withNoMatches() {
        List<List<Integer>> lottoTickets = Arrays.asList(
                Arrays.asList(8, 9, 10, 11, 12, 13),
                Arrays.asList(14, 15, 16, 17, 18, 19)
        );
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> result = Lotto.calculateWinningResults(lottoTickets, winNumber, bonusNumber);

        // 1등: 0개
        assertEquals(0, result.get(Rank.FIRST));
        // 2등: 0개
        assertEquals(0, result.get(Rank.SECOND));
    }

    @Test
    void testCalculateWinningResults_withMixedMatches() {
        List<List<Integer>> lottoTickets = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),  // 1등
                Arrays.asList(1, 2, 3, 4, 5, 7),  // 2등
                Arrays.asList(1, 2, 3, 8, 9, 10), // 3등
                Arrays.asList(1, 2, 11, 12, 13, 14), // 4등
                Arrays.asList(15, 16, 17, 18, 19, 20) // 미당첨
        );
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> result = Lotto.calculateWinningResults(lottoTickets, winNumber, bonusNumber);

        assertEquals(1, result.get(Rank.FIRST)); // 1등: 1개
        assertEquals(1, result.get(Rank.SECOND)); // 2등: 1개
        assertEquals(0, result.get(Rank.THIRD)); // 3등: 0개
        assertEquals(1, result.get(Rank.FOURTH)); // 4등: 1개
        assertEquals(0, result.get(Rank.FIFTH)); // 5등: 0개
        assertEquals(1, result.get(Rank.NONE)); // 미당첨: 1개
    }
}
