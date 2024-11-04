package lotto;

import lotto.model.Lotteries;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteriesTest {
    @DisplayName("입력받은 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 입력받은_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotteries(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 금액이 1000원 단위인지 확인한다.")
    @Test
    void 입력받은_금액이_1000원_단위인지_확인한다() {
        assertSimpleTest(() -> {
            Lotteries lotteries = new Lotteries(2000);
            assertThat(lotteries.formatOutput()).contains("2개를 구매했습니다.");
        });
    }
}
