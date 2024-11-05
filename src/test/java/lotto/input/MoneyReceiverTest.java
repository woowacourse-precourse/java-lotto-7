package lotto.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyReceiverTest {

    @Test
    @DisplayName("성공 - 유효한 금액 입력")
    void success_receiveMoney() {
        // given
        InputProvider mockInputProvider = () -> "5000";
        Receiver<Money> moneyReceiver = new MoneyReceiver(mockInputProvider);

        // when
        Money money = moneyReceiver.receiveWithMessage();

        // then
        assertThat(money.amount()).isEqualTo(5000);
    }

    @Test
    @DisplayName("실패 - 빈 입력")
    void fail_receiveMoney_emptyInput() {
        // given
        InputProvider mockInputProvider = () -> "";
        Receiver<Money> moneyReceiver = new MoneyReceiver(mockInputProvider);

        // when & then
        assertThatThrownBy(() -> moneyReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 유효하지 않은 숫자 형식입니다. 입력한 값 : ");
    }

    @Test
    @DisplayName("실패 - 숫자가 아닌 입력")
    void fail_receiveMoney_nonNumericInput() {
        // given
        InputProvider mockInputProvider = () -> "abc";
        Receiver<Money> moneyReceiver = new MoneyReceiver(mockInputProvider);

        // when & then
        assertThatThrownBy(() -> moneyReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("실패 - 금액이 1000원 미만")
    void fail_receiveMoney_lessThanThousand() {
        // given
        InputProvider mockInputProvider = () -> "500";
        Receiver<Money> moneyReceiver = new MoneyReceiver(mockInputProvider);

        // when & then
        assertThatThrownBy(() -> moneyReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 입력한 금액은 1000원보다 커야 합니다.");
    }

    @Test
    @DisplayName("실패 - 금액이 1000원 단위가 아님")
    void fail_receiveMoney_notMultipleOfThousand() {
        // given
        InputProvider mockInputProvider = () -> "1500";
        Receiver<Money> moneyReceiver = new MoneyReceiver(mockInputProvider);

        // when & then
        assertThatThrownBy(() -> moneyReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 돈은 1000원 단위로 입력해주세요.");
    }

    @Test
    @DisplayName("실패 - 금액이 정수의 최대값 초과")
    void fail_receiveMoney_exceedsIntegerMaxValue() {
        // given
        InputProvider mockInputProvider = () -> "2147483648"; // Integer.MAX_VALUE + 1
        Receiver<Money> moneyReceiver = new MoneyReceiver(mockInputProvider);

        // when & then
        assertThatThrownBy(() -> moneyReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 입력한 값이 정수의 최대값을 초과했습니다.");
    }
}
