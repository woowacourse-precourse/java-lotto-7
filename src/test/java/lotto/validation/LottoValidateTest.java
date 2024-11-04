package lotto.validation;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoValidateTest {
    @Test
    @DisplayName("입력 금액 정상")
    void purchaseMoneyOk() {
        int money = 1000;
        LottoTokenValidator.validatePurchaseNumber(money);
        Assertions.assertEquals(1000, money);
    }

    @Test
    @DisplayName("입력 금액 1000의 배수 아님")
    void notThousandMultiple() {
        int money = 999;
        LottoException exception = Assertions.assertThrows(LottoException.class, () -> LottoTokenValidator.validatePurchaseNumber(money));
        Assertions.assertEquals(LottoExceptionCode.NEED_MULTIPLE_OF_THOUSAND, exception.getCode());
    }

    @Test
    @DisplayName("입력 금액 범위 잘못됨")
    void notValidPurchaseMoney() {
        int money = -1;
        LottoException lottoException = Assertions.assertThrows(LottoException.class, () -> LottoTokenValidator.validatePurchaseNumber(money));
        Assertions.assertEquals(LottoExceptionCode.PURCHASE_MONEY_FORMAT_ERROR, lottoException.getCode());
    }

    @Test
    @DisplayName("0원은 정상입력")
    void zeroInput() {
        int money = 0;
        LottoTokenValidator.validatePurchaseNumber(money);
        Assertions.assertEquals(0, money);
    }

    @Test
    @DisplayName("로또 번호 정상 입력")
    void lottoNumberOk() {
        for (int i = 1; i <= 45; i++) {
            LottoTokenValidator.validateLottoNumber(i);
        }
    }

    @Test
    @DisplayName("음수 또는 46 이상")
    void notValidLottoNumber() {
        int lotto = -1;
        LottoException lottoException1 = Assertions.assertThrows(LottoException.class, () -> LottoTokenValidator.validateLottoNumber(lotto));
        Assertions.assertEquals(LottoExceptionCode.LOTTO_NUMBER_FORMAT_ERROR, lottoException1.getCode());

        int lotto2 = 46;
        LottoException lottoException2 = Assertions.assertThrows(LottoException.class, () -> LottoTokenValidator.validateLottoNumber(lotto2));
        Assertions.assertEquals(LottoExceptionCode.LOTTO_NUMBER_FORMAT_ERROR, lottoException2.getCode());
    }
}
