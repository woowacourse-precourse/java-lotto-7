package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import lotto.constant.ExceptionMessage;
import lotto.entity.Prize;
import lotto.entity.PurchaseAmount;
import org.junit.jupiter.api.Test;

class StatisticModelTest {

    private StatisticModel statisticModel;

    @Test
    void 기본_생성자는_상품의_순서를_순서대로_설정한다() {
        // given

        // when
        statisticModel = new StatisticModel();

        // then
        Map<Prize, Long> prizes = statisticModel.getPrizes();
        List<Prize> prizeOrder = List.of(Prize.FIFTH, Prize.FOURTH, Prize.THIRD, Prize.SECOND, Prize.FIRST);

        int index = 0;
        for (Prize prize : prizes.keySet()) {
            assertThat(prizeOrder.get(index)).isEqualTo(prize);
            index++;
        }
    }

    @Test
    void add_추가_상품을_받아_통계_수치가_1_올라간다() {
        // given
        statisticModel = new StatisticModel();
        statisticModel.setPurchaseAmount(new PurchaseAmount(1000L));

        Prize prize = Prize.FIRST;

        // when
        statisticModel.add(prize);

        // then
        assertThat(statisticModel.getPrizes().get(prize)).isEqualTo(1L);
    }

    @Test
    void add_구매금액이_입력되지_않아_오류가_발생한다() {
        // given
        statisticModel = new StatisticModel();

        Prize prize = Prize.FIRST;

        // when

        // then
        assertThatThrownBy(() -> statisticModel.add(prize))
                .isInstanceOf(NoSuchElementException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_NOT_SETTING);
    }
}