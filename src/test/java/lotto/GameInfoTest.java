package lotto;

import lotto.Domain.GameInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import lotto.Constants.Error;

public class GameInfoTest {

    @ParameterizedTest
    @DisplayName("구매금엑 테스트. 최소금액 보다 적은경우")
    @ValueSource(ints = {0, -1000, -999, 999})
    public void 구매금액_테스트_최소금액_lower_bound(int purchaseAmount) {
        assertThatThrownBy(() -> new GameInfo(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.PURCHASE_AMOUNT_LT_MINIMUM.getText());
    }

    @ParameterizedTest
    @DisplayName("구매금액 테스트. 1000 단위로 떨어지지 않을 경우")
    @ValueSource(ints = {1001, 1100, 2001})
    public void 구매금액_테스트_단위테스트(int purchaseAmount) {
        assertThatThrownBy(() -> new GameInfo(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getText());
    }
}
