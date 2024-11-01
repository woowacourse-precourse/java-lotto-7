package lotto;

import static lotto.LottoConstants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoSellerTest {
    @DisplayName("로또 1개 가격이 1,000원일 때 구입 금액에 따른 구매 수량을 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,0", "1000,1", "8000,8", "10000000,10000", "950000000,950000"})
    void returnQuantityCanBeBoughtWith(BigInteger amount, int expected) {
        LottoSeller lottoSeller = new LottoSeller(LOTTO_PRICE);

        int actual = lottoSeller.calculateQuantityWith(amount);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("로또 1개 가격과 구입 금액에 따른 구매 수량을 반환한다.")
    @ParameterizedTest
    @CsvSource({"5000,0,0", "10000,70000,7", "1,8000,8000", "30000,360000,12", "100,950000000,9500000"})
    void returnQuantityCanBeBoughtWith(int price, BigInteger amount, int expected) {
        LottoSeller lottoSeller = new LottoSeller(price);

        int actual = lottoSeller.calculateQuantityWith(amount);

        assertThat(actual).isEqualTo(expected);
    }
}