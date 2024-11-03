package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager();
    }

    @Test
    void 당첨로또_저장_성공_테스트() {
        // given
        LottoManager lottoManager = new LottoManager();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        Lotto savedLotto = lottoManager.saveWinningLotto(winningLotto);

        // then
        assertThat(savedLotto).isNotNull();
        assertThat(savedLotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 보너스번호_중복시_예외_테스트() {
        // given
        LottoManager lottoManager = new LottoManager();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoManager.saveWinningLotto(winningLotto);

        // when / then
        assertThatThrownBy(() -> lottoManager.saveBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_범위_검증_1미만인_경우_예외_테스트() {
        // given
        LottoManager lottoManager = new LottoManager();

        // when / then
        assertThatThrownBy(() -> lottoManager.saveBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_범위_검증_45초과인_경우_예외_테스트_46() {
        // given
        LottoManager lottoManager = new LottoManager();

        // when / then
        assertThatThrownBy(() -> lottoManager.saveBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨통계_성공_테스트() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoManager.saveWinningLotto(winningLotto);
        lottoManager.saveBonusNumber(7);

        List<Lotto> customerLottos = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        // when
        lottoManager.statisticsCustomerWinning(customerLottos);

        // then
        Map<String, Integer> map = lottoManager.getStatistics();
        assertThat(map.get("3")).isEqualTo(1);
        assertThat(map.get("4")).isEqualTo(1);
        assertThat(map.get("5")).isEqualTo(0);
        assertThat(map.get("5B")).isEqualTo(1);
        assertThat(map.get("6")).isEqualTo(1);
    }


    @Test
    void 수익률_계산_테스트() {
        // given
        Integer payment = 8000;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoManager.saveWinningLotto(winningLotto);
        lottoManager.saveBonusNumber(7);

        List<Lotto> customerLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        lottoManager.statisticsCustomerWinning(customerLottos);

        // when
        BigDecimal rateOfRevenue = lottoManager.getRateOfRevenue(payment);
        BigDecimal expectedRate = BigDecimal.valueOf(2030000000)
                .divide(BigDecimal.valueOf(8000), 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);

        // then
        assertThat(rateOfRevenue).isEqualTo(expectedRate);
    }
}