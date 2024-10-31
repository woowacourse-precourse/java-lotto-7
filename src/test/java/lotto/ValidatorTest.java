package lotto;

import lotto.exception.lottoPrice.InvalidThousandUnitException;
import lotto.exception.lottoPrice.MinimumPriceException;
import lotto.exception.lottoPrice.NullPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void 로또금액_공백_테스트(){
        String input = "";
        assertThatThrownBy(()->validator.isValidPrice(input))
                .isInstanceOf(NullPriceException.class)
                .hasMessage("금액은 null일 수 없습니다.");
    }

    @Test
    void 로또금액_1000원이상_테스트(){
        String input = "999";
        assertThatThrownBy(()->validator.isValidPrice(input))
                .isInstanceOf(MinimumPriceException.class)
                .hasMessage("최소 금액은 1,000원 이상이어야 합니다.");
    }

    @Test
    void 로또금액_1000원단위_테스트(){
        String input = "2500";
        assertThatThrownBy(()->validator.isValidPrice(input))
                .isInstanceOf(InvalidThousandUnitException.class)
                .hasMessage("1,000원 단위의 금액만 입력 가능합니다.");
    }




}
