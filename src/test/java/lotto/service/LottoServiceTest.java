package lotto.service;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        this.lottoService = new LottoService();
    }

    @Test
    void 유효_문자열_구매_금액_반환() {
        int purchaseMoney = lottoService.getPurchaseMoney("10000");
        assertThat(purchaseMoney).isEqualTo(10000);
    }

    @Test
    void 유효하지_않은_문자열_예외_발생() {
        assertThatThrownBy(() -> lottoService.getPurchaseMoney("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효_금액_로또_개수_반환() {
        int lottoCount = lottoService.getLottoCount(10000);
        assertThat(lottoCount).isEqualTo(10);
    }

    @Test
    void 유효하지_않은_금액_예외_발생() {
        assertThatThrownBy(() -> lottoService.getLottoCount(10001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사이즈_만큼_로또_발행() {
        List<Lotto> lottos = lottoService.generateLottos(10);
        assertThat(lottos).hasSize(10);
        lottos.forEach(lotto -> assertThat(lotto.getNumbers()).hasSize(6));
    }

    @Test
    void 당첨_개수_반환() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Map<String, Integer> matchCounts = lottoService.getMatchCounts(lottos, winningLotto, bonusNumber);
        assertThat(matchCounts.get("6")).isEqualTo(1);
        assertThat(matchCounts.get("5.5")).isEqualTo(1);
        assertThat(matchCounts.get("5")).isEqualTo(0);
        assertThat(matchCounts.get("4")).isEqualTo(0);
        assertThat(matchCounts.get("3")).isEqualTo(0);
    }

    @Test
    void 유효_로또_번호_당첨_로또_반환() {
        Lotto winningLotto = lottoService.getWinningLotto(" 1  , 2,  3  , 4, 5, 6");
        assertThat(winningLotto.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 유효하지_않은_로또_번호_예외_발생() {
        assertThatThrownBy(() -> lottoService.getWinningLotto("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 총_상금_계산_후_반환() {
        Map<String, Integer> matchCounts = Map.of(
                "6", 1, "5.5", 1,
                "5", 0, "4", 0,
                "3", 0, "2", 0,
                "1", 0, "0", 0);
        long totalPrizeMoney = lottoService.getPrizeMoney(matchCounts);
        assertThat(totalPrizeMoney).isEqualTo(2000000000 + 30000000);
    }

    @Test
    void 유효_숫자_보너스_번호_반환() {
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = lottoService.getBonusNumber("7", winningLottoNumbers);
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    void 유효하지_않은_숫자_예외_발생() {
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> lottoService.getBonusNumber("6", winningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률_계산_후_반환() {
        String rateOfReturn = lottoService.getRateOfReturn(2030000000, 5000);
        assertThat(rateOfReturn).isEqualTo("40600000.0");
    }
}