package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.global.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserAccountTest {
    private UserAccount userAccount;

    @BeforeEach
    void setUp() {
        userAccount = UserAccount.of("1000");
    }

    @DisplayName("생성에 성공한다.")
    @Test
    void construct() {
        Assertions.assertThat(userAccount).isNotNull();
    }

    @DisplayName("입력된 money 를 바탕으로 횟수를 도출 가능하다.")
    @Test
    void getTicketCount() {
        Assertions.assertThat(userAccount.getTicketCount()).isEqualTo(1);
    }

    @DisplayName("사용자 입력 금액이 올바르지 않으면 예외가 발생한다")
    @Test
    void validation() {
        String invalidUserInput = "1001"; // 1000 으로 떨어지지 않음
        assertThatThrownBy(() -> UserAccount.of(invalidUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY.getMessage());
    }

    @DisplayName("수익률 계산에 성공한다")
    @Test
    void getEarningRate() {
        float earningRate = userAccount.calculateEarningRate(1000);
        Assertions.assertThat(earningRate).isEqualTo(100.0f);
    }
}
