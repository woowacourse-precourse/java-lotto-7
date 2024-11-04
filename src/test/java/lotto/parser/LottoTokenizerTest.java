package lotto.parser;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTokenizerTest {
    @Test
    @DisplayName("입력 금액이 숫자 형식이 아닌 경우")
    void notNumberFormatPurchaseMoney() {
        LottoException exception = Assertions.assertThrows(LottoException.class, () -> LottoTokenizer.getPurchaseMoney("asd"));
        Assertions.assertEquals(LottoExceptionCode.PURCHASE_MONEY_FORMAT_ERROR, exception.getCode());
    }

    @Test
    @DisplayName("입력 로또 번호가 숫자 형식이 아닌 경우")
    void notNumberFormatLottoNumber() {
        LottoException exception = Assertions.assertThrows(LottoException.class, () -> LottoTokenizer.getLottoNumber("xyz"));
        Assertions.assertEquals(LottoExceptionCode.LOTTO_NUMBER_FORMAT_ERROR, exception.getCode());
    }
}