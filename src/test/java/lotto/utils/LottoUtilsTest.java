package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.LottoExceptionStatus.INVALID_LOTTO_PURCHASE_NUMBER_FORMAT;
import static lotto.exception.LottoExceptionStatus.INVALID_WINNING_NUMBER_FORMAT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoUtilsTest {

    @Test
    @DisplayName("입력 금액 형식이 올바르지 않음")
    void invalidPurchaseAmount_Format(){
        String purchaseAmount = "1000A";

        assertThatThrownBy(() -> LottoUtils.checkPurchaseNumberFormat(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_PURCHASE_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("입력 금액 형식이 올바르지 않음")
    void invalidWinningLotto_Format(){
        String winningLotto = "1,2,3,4,5,6a";

        assertThatThrownBy(() -> LottoUtils.checkLottoNumberFormat(winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_WINNING_NUMBER_FORMAT.getMessage());
    }
}
