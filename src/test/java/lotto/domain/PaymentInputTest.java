package lotto.domain;
import lotto.common.ErrorMessage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentInputTest {

    @ParameterizedTest
    @ValueSource(ints = {0,900})
    void 입력이_1000으로_나누어떨어지지_않으면_예외_발생(int input){
        assertThatThrownBy(() -> new PaymentInput(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.NOT_UNIT_INPUT);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10,-10000})
    void 입력이_음수이면_예외발생(int input){
        assertThatThrownBy(() -> new PaymentInput(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.NOT_POSITIVE_INPUT);
    }

    @Test
    void 올바르게_금액을_입력하면_금액과_개수를_반환한다(){
        PaymentInput paymentInput=new PaymentInput(4000);

        assertAll(
                ()->assertEquals(paymentInput.getLottoCounts(),4),
                ()->assertEquals(paymentInput.getPayment(),4000)
        );
    }





}