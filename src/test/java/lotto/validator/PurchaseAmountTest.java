package lotto.validator;


import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.dto.PurchaseAmountDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest extends NsTest {

    @Test
    void 금액이_올바른_값을_갖는_경우() throws Exception{
        PurchaseAmountDto dto = PurchaseAmountValidator.validate("3000");
        assertThat(dto.value).isEqualTo(3000);
    }

    @Test
    void 금액이_1000_단위가_아닌_경우() throws Exception{
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("210");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_0원인_경우() throws Exception{
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_음수인_경우() throws Exception{
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("-200");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_아무런_값을_갖지_않는_경우() throws Exception{
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_공백을_갖는_경우() throws Exception{
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }
}
