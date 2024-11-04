package lotto;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.model.type.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoListTest {
    private LottoList lottoList;

    @BeforeEach
    void setUp() {
        lottoList = new LottoList();
    }

    @DisplayName("구매 금액에 맞는 수의 로또가 생성되어야 한다")
    @Test
    void 로또_구매_개수_테스트() {
        // given
        int money = 3000;
        LottoController controller = new LottoController();

        // when
        controller.createLottos(money);

        // then
        assertThat(controller.getLottos().size()).isEqualTo(3);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
    @Test
    void 보너스번호_중복_테스트() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int duplicatedBonusNum = 1;

        // when & then
        assertThatThrownBy(() -> lottoList.setWinningNumber(new Lotto(winningNumbers), duplicatedBonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 통계가 올바르게 계산되어야 한다")
    @Test
    void 당첨_통계_테스트() {
        // given
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));  // 1등
        lottoList.setWinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        // when
        Map<LottoRank, Integer> statistics = lottoList.calculateWinningStat();

        // then
        assertThat(statistics.get(LottoRank.FIRST)).isEqualTo(1);
    }


}
