package lotto.Model;


import lotto.Constants;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoAmountValidatorTest {
    @Test
    void 로또_구입금액은_공백이어선안된다(){
        assertThatThrownBy(()->new LottoAmountValidator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.LOTTO_AMOUNT_BLANK_ERROR);;
    }
    @Test
    void 로또_구입금액은_문자열이포함되어있으면안된다(){
        assertThatThrownBy(()->new LottoAmountValidator("1000않"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.LOTTO_AMOUNT_CONTAINS_STRING_ERROR);
    }
    @Test
    void 로또_구입금액은_1000원단위여야한다(){
        assertThatThrownBy(()-> new LottoAmountValidator("10100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.LOTTO_AMOUNT_UNIT_ERROR);
    }
}