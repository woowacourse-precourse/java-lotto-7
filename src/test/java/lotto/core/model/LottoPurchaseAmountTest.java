package lotto.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseAmountTest {

    @Test
    @DisplayName("숫자 10000으로 로또 구입 금액을 생성한다.")
    void create_LottoPurchaseAmount_when_value_is_number_should_be_pass() {
        // given
        // when
        Integer value = 10000;
        LottoPurchaseAmount amount = new LottoPurchaseAmount(value);
        // then
        Assertions.assertEquals(value, amount.getValue());
        Assertions.assertEquals(10, amount.getLottoCount());
    }

    @Test
    @DisplayName("문자열 '100000'으로 로또 구입 금액을 생성한다.")
    void create_LottoPurchaseAmount_when_value_is_String_should_be_pass() {
        // given
        // when
        String value = "100000";
        LottoPurchaseAmount amount = new LottoPurchaseAmount(value);
        // then
        Assertions.assertEquals(Integer.parseInt(value), amount.getValue());
        Assertions.assertEquals(100, amount.getLottoCount());
    }
    
    @Test
    @DisplayName("문자열 null 로 로또 구입 금액을 생성하면 예외가 발생한다.")
    void create_LottoPurchaseAmount_when_value_is_String_type_null_should_be_fail() {
        // given
        // when
        String value = null;
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoPurchaseAmount(value));
        Assertions.assertEquals("로또 구입 금액을 입력해주세요.", ex.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 문자열로 로또 구입 금액을 생성하면 예외가 발생한다.")
    void create_LottoPurchaseAmount_when_value_is_String_type_Nan_should_be_fail() {
        // given
        // when
        String value = "value";
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoPurchaseAmount(value));
        Assertions.assertEquals("로또 구입 금액은 숫자만 입력해주세요.", ex.getMessage());
    }
    
    @Test
    @DisplayName("Integer 타입의 null 로 로또 구입 금액을 생성하면 예외가 발생한다.")
    void create_LottoPurchaseAmount_when_value_is_Integer_type_null_should_be_fail() {
        // given
        // when
        Integer value = null;
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoPurchaseAmount(value));
        Assertions.assertEquals("로또 구입 금액을 입력해주세요.", ex.getMessage());
    }
    
    @Test
    @DisplayName("숫자 100으로 로또 구입 금액을 생성하면 예외가 발생한다.")
    void create_LottoPurchaseAmount_when_value_is_less_than_1000_should_be_fail() {
        // given
        // when
        Integer value = 100;
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoPurchaseAmount(value));
        Assertions.assertEquals("로또 구입 금액은 1000 이상의 숫자를 입력해주세요.", ex.getMessage());
    }
    
    @Test
    @DisplayName("숫자 2500으로 로또 구입 금액을 생성하면 예외가 발생한다.")
    void create_LottoPurchaseAmount_when_non_unit_1000_value_should_be_fail() {
        // given
        // when
        Integer value = 2500;
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoPurchaseAmount(value));
        Assertions.assertEquals("로또 구입 금액은 1000 단위의 숫자를 입력해주세요.", ex.getMessage());
    }
}
