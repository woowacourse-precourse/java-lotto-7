package lotto.model.lotto;

import lotto.exception.LottoErrorStatus;
import lotto.exception.LottoException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자의 로또 구매 예산 모델 테스트")
class BudgetTest {

    @Test
    public void 사용자_천원_단위_입력시_정상_생성() {
        // given
        int money = 20000;

        // when
        Budget budget = new Budget(money);

        // then
        Assertions.assertThat(budget).isNotNull();
    }

    @Test
    public void 사용자_천원_단위_미입력시_예외_발생() {
        // given
        int money = 22300;

        // when, then
        Assertions.assertThatThrownBy(() -> new Budget(money))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorStatus.INVALID_BUDGET_UNIT.getMessage());
    }

    @Test
    public void 사용자_0원_입력시_예외_발생() {
        // given
        int money = 0;

        // when, then
        Assertions.assertThatThrownBy(() -> new Budget(money))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorStatus.INVALID_BUDGET_UNIT.getMessage());
    }
}
