package lotto.controller.moneyController;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import lotto.testUtil.testDouble.InputHandlerStub;
import org.junit.jupiter.api.Test;

class DefaultMoneyControllerTest {

    @Test
    void 돈을_반환한다() {
        //given
        InputHandlerStub inputHandlerStub = new InputHandlerStub();
        DefaultMoneyController sut = new DefaultMoneyController(inputHandlerStub);
        inputHandlerStub.stubPurchaseCost(10000);

        //when
        Money result = sut.readMoney();

        //then
        assertThat(result.getAmount()).isEqualTo(10000);
    }
}
