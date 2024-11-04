package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private LottoRound lottoRound;
    private Order order;

    @BeforeEach
    void setUp() {
        int orderCount = 5;
        lottoRound = new LottoRound(1);
        order = new Order(lottoRound, orderCount);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        lottoRound.setWinningLotto(winningLotto);
        lottoRound.setBonusNumber(bonusNumber);
    }

    @Test
    @DisplayName("로또 번호 생성 확인")
    void testGenerateOrderedLotto() {
        order.generateOrderedLotto(5);

        assertThat(order.orderedLottos).hasSize(5);
    }

    @Test
    @DisplayName("일치하는 번호와 보너스 번호로 매칭 카운트 계산")
    void testCalculateMatchCounts() {
        //given
        order.orderedLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))); // 1등 - 6개일치
        order.orderedLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))); // 2등 - 5개일치 + 보너스일치
        order.orderedLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9))); // 3등 - 5개일치 + 보너스불일치
        order.orderedLottos.add(new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11))); // 1개일치
        order.orderedLottos.add(new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))); // 0개일치

        // when
        order.calculateMatchCounts();

        // then
        assertThat(order.getMatchCounts().get(6)).isEqualTo(1); // 1등 - 6개 맞은 경우
        assertThat(order.getMatchCounts().get(7)).isEqualTo(1); // 2등 - 5개 맞은 경우 + 보너스 맞은 경우
        assertThat(order.getMatchCounts().get(5)).isEqualTo(1); // 3등 - 5개 맞은 경우 + 보너스 불일치
        assertThat(order.getMatchCounts().get(1)).isEqualTo(1); // 1개 일치
        assertThat(order.getMatchCounts().get(0)).isEqualTo(1); // 0개 일치
    }

    @Test
    @DisplayName("총 수익률 계산 확인")
    void testCalculateTotalProfit() {
        // given
        order.orderedLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))); // 1등 - 6개일치
        order.orderedLottos.add(new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))); // 0개일치
        order.orderedLottos.add(new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))); // 0개일치
        order.orderedLottos.add(new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))); // 0개일치
        order.orderedLottos.add(new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))); // 0개일치

        // when
        // 5000원으로 1등 당첨 시 수익률 = 40000000.0%
        order.calculateMatchCounts();
        double expectedTotalProfit = 40000000.0;
        double totalProfit = order.calculateTotalProfit();

        // then
        assertThat(totalProfit).isEqualTo(expectedTotalProfit);
    }
}