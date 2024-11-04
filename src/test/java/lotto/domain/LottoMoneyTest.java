package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.util.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1100, 1200, 2600, 2040, 2003})
    void 돈_천원_단위가_아닌_입력(int money) {
        // given
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new LottoMoney(money));

        // then
        Assertions.assertThat(e.getMessage()).isEqualTo(ErrorMessage.MONEY_NOT_MODED_PRICE.getMsg());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -30, -1000, -1500, -2000, 989, 853, 500})
    void 돈_1000원_이하_입력(int money) {
        // given
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new LottoMoney(money));

        // then
        Assertions.assertThat(e.getMessage()).isEqualTo(ErrorMessage.MONEY_LESS_THEN_MINIMUM.getMsg());
    }

    @ParameterizedTest
    @ValueSource(ints = {10000000, 1000001, 1100000})
    void 돈_100만원_이상_입력(int money) {
        // given
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new LottoMoney(money));

        // then
        Assertions.assertThat(e.getMessage()).isEqualTo(ErrorMessage.MONEY_MORE_THEN_MAXIMUM.getMsg());
    }

}