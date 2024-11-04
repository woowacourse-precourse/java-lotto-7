package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또 번호 개수 부족 테스트")
    void testLottoCreation_InvalidNumberCount() {
        List<Integer> numbers = Arrays.asList(8, 21, 23, 41, 42);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 범위 초과 테스트")
    void testLottoCreation_NumberOutOfRange() {
        List<Integer> numbers = Arrays.asList(0, 21, 23, 41, 42, 46);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 중복 테스트")
    void testLottoCreation_DuplicateNumbers() {
        List<Integer> numbers = Arrays.asList(8, 21, 23, 41, 41, 43);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("1등 당첨 테스트")
    void testGetRank_FirstPrize() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        Rank rank = lotto.getRank(numbers, 7);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등 당첨 테스트")
    void testGetRank_SecondPrize() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Rank rank = lotto.getRank(winningNumbers, 7);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등 당첨 테스트")
    void testGetRank_ThirdPrize() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 8);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Rank rank = lotto.getRank(winningNumbers, 7);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4등 당첨 테스트")
    void testGetRank_FourthPrize() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 8, 9);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Rank rank = lotto.getRank(winningNumbers, 7);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("5등 당첨 테스트")
    void testGetRank_FifthPrize() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Rank rank = lotto.getRank(winningNumbers, 7);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("꽝 테스트")
    void testGetRank_NoPrize() {
        List<Integer> numbers = Arrays.asList(7, 8, 9, 10, 11, 12);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Rank rank = lotto.getRank(winningNumbers, 7);
        assertThat(rank).isNull();
    }

    @Test
    @DisplayName("로또 번호 정렬 출력 테스트")
    void testLottoToString() {
        List<Integer> numbers = Arrays.asList(42, 8, 23, 41, 21, 43);
        Lotto lotto = new Lotto(numbers);
        String expected = "[8, 21, 23, 41, 42, 43]";
        assertThat(lotto.toString()).isEqualTo(expected);
    }
}