package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    @DisplayName("로또 구매 테스트 성공")
    void shouldCreateUserWithValidMoney() {
        // given
        String inputMoney = "2000";

        // when
        User user = new User(inputMoney);

        // then
        assertThat(user.getMoney()).isEqualTo(2000);
        assertThat(user.getLottos()).hasSize(2);
    }

    @Test
    @DisplayName("로또 금액 입력 테스트 실패")
    void shouldThrowExceptionForInvalidMoneyFormat() {
        // given
        String inputMoney = "abcd";

        // when & then
        assertThatThrownBy(() -> new User(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자가 아닌 값을 입력하였습니다.");
    }

    @Test
    @DisplayName("로또 금액 입력 테스트 실패2")
    void shouldThrowExceptionForInvalidPurchaseAmount() {
        // given
        String inputMoney1 = "1500";
        String inputMoney2 = "500";

        // when & then
        assertThatThrownBy(() -> new User(inputMoney1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위 및 1,000원 이상이여야 합니다.");

        assertThatThrownBy(() -> new User(inputMoney2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위 및 1,000원 이상이여야 합니다.");
    }

    @Test
    @DisplayName("로또 구매 테스트 성공")
    void shouldGenerateLottoNumbers() {
        // given
        String inputMoney = "3000";

        // when
        User user = new User(inputMoney);

        // then
        assertThat(user.getLottos()).hasSize(3);
        user.getLottos().forEach(lotto -> {
            assertThat(lotto.getNumbers()).hasSize(6);
            lotto.getNumbers().forEach(number -> {
                assertThat(number).isBetween(1, 45);
            });
        });
    }
}
