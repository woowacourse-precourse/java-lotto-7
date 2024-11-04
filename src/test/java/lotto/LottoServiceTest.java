package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("3개 번호가 일치하면 THREE_MATCH 결과가 반환된다.")
    @Test
    void testThreeMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        List<Integer> winNumbers = List.of(1, 2, 3, 20, 30, 40);
        LottoResult result = lottoService.checkWinning(lotto, winNumbers, 7);
        assertThat(result).isEqualTo(LottoResult.THREE_MATCH);
    }

    @DisplayName("4개 번호가 일치하면 FOUR_MATCH 결과가 반환된다.")
    @Test
    void testFourMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 30, 40);
        LottoResult result = lottoService.checkWinning(lotto, winNumbers, 7);
        assertThat(result).isEqualTo(LottoResult.FOUR_MATCH);
    }

    @DisplayName("5개 번호가 일치하면 FIVE_MATCH 결과가 반환된다.")
    @Test
    void testFiveMatchWithoutBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 40);
        LottoResult result = lottoService.checkWinning(lotto, winNumbers, 7);
        assertThat(result).isEqualTo(LottoResult.FIVE_MATCH);
    }

    @DisplayName("5개 번호 일치하고, 보너스 번호가 일치하지 않으면 FIVE_BONUS_MATCH 결과가 반환된다.")
    @Test
    void testFiveMatchWithBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 40);
        LottoResult result = lottoService.checkWinning(lotto, winNumbers, 14); // 보너스 번호 포함
        assertThat(result).isEqualTo(LottoResult.FIVE_BONUS_MATCH);
    }

    @DisplayName("6개 번호가 일치하면 SIX_MATCH 결과가 반환된다.")
    @Test
    void testSixMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoResult result = lottoService.checkWinning(lotto, winNumbers, 7);
        assertThat(result).isEqualTo(LottoResult.SIX_MATCH);
    }

    @DisplayName("일치하는 번호가 없으면 null이 반환된다.")
    @Test
    void testNoMatch() {
        Lotto lotto = new Lotto(List.of(10, 20, 30, 40, 41, 42));
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoResult result = lottoService.checkWinning(lotto, winNumbers, 7);
        assertThat(result).isEqualTo(null);
    }
}
