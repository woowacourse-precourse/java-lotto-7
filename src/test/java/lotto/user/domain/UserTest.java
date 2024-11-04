package lotto.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {

    @DisplayName("예외 | 잘못된 금액이 입력될 경우")
    @ParameterizedTest
    @ValueSource(ints = {10, 100, 900, 999, 1001, 1100, -1000})
    void should_ThrowException_When_MoneyIsInvalid(int money) {
        assertThatThrownBy(() -> new User(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("성공 | 정상적인 금액이 입력될 경우")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000})
    void should_CreateUser_When_MoneyIsValid(int money) {
        User user = new User(money);

        assertThat(user).isNotNull();
    }

    @DisplayName("성공 | 구매할 수 있는 로또의 개수")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "2000, 2", "3000, 3", "4000, 4", "5000, 5", "6000, 6", "7000, 7", "8000, 8",
            "9000, 9"})
    void should_ReturnNumberOfLottos_When_CanBuyLotto(int money, int expected) {
        User user = new User(money);

        assertThat(user.calculateAvailableNumberOfLotto()).isEqualTo(expected);
    }
}