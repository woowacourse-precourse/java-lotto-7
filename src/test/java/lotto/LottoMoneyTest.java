package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 900000})
    @DisplayName("1000원 단위의 숫자를 입력하면 성공")
    void LottoMoney_생성_성공(int money) {
        assertDoesNotThrow(() -> new LottoMoney(money));
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 10002, 5500})
    @DisplayName("1000원 단위의 숫자를 입력하지 않으면 예외 발생")
    void LottoMoney_생성_실패(int money) {
        assertThatThrownBy(() -> new LottoMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}