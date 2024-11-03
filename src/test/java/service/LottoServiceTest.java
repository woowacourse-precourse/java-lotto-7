package service;

import model.Lotto;
import model.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 유효한_금액_문자열_입력() {
        int result = lottoService.purchaseAmount("8000");
        assertThat(result).isEqualTo(8000);
    }

    @Test
    void 숫자가_아닌_문자열_입력_예외() {
        assertThatThrownBy(() -> lottoService.purchaseAmount("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 로또_발행_개수_확인() {
        int count = 3;

        List<Lotto> result = lottoService.publishLotto(count);

        assertThat(result).hasSize(count);
        result.forEach(lotto -> assertThat(lotto.getNumbers()).hasSize(6));
    }

    @Test
    void 유효하지_않은_구분자_예외_발생() {
        assertThatThrownBy(() -> lottoService.inputWinningNumber("1/2/3/4/5/6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 올바른_당첨_번호() {
        Lotto result = lottoService.inputWinningNumber("1,2,3,4,5,6");

        assertThat(result.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 보너스_번호가_유효하지_않은_경우_예외_발생() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lottoService.bonusNumber("3", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 통계_결과_확인() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9))
        );
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        Map<Rank, Integer> result = lottoService.calculateStatistics(lottoList, winningLotto, bonusNumber);

        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    void 수익률_계산_결과_확인() {
        Map<Rank, Integer> rankCount = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 1,
                Rank.FIFTH, 1,
                Rank.MISS, 0
        );
        int purchaseAmount = 5000;

        double result = lottoService.totalReturn(rankCount, purchaseAmount);

        double expectedReturn = ((double) (Rank.FIRST.amount + Rank.FOURTH.amount + Rank.FIFTH.amount)) / purchaseAmount * 100;
        assertThat(result).isEqualTo(expectedReturn);
    }
}
