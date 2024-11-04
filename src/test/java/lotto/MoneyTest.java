package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("정상 금액으로 Money 객체를 생성한다.")
    @Test
    void 정상_금액으로_Money_객체를_생성한다() {
        int validMoney = 6000;
        Money money = new Money(validMoney);

        assertThat(money.getMoney()).isEqualTo(validMoney);
    }

    @DisplayName("금액이 1000원 미만일 경우 예외가 발생한다.")
    @Test
    void 금액이_1000원_미만일_경우_예외가_발생한다() {
        int invalidMoney = 500;

        assertThatThrownBy(() -> new Money(invalidMoney)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 이상의 금액을 입력해야합니다.");
    }

    @DisplayName("금액이 1000원으로 나누어떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void 금액이_1000원으로_나누어떨어지지_않을_경우_예외가_발생한다() {
        int invalidMoney = 1500;

        assertThatThrownBy(() -> new Money(invalidMoney)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 1000원으로 나누어 떨어져야합니다.");
    }

    @DisplayName("정상 금액으로 로또 구매 가능한 티켓 수 계산")
    @Test
    void 정상_금액으로_로또_구매_가능한_티켓_수_계산() {
        Money money = new Money(6000);
        int ticketCount = money.calculateLottoTickets();

        assertThat(ticketCount).isEqualTo(6);
    }
}
