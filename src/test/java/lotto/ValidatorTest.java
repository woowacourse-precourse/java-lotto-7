package lotto;

import lotto.exception.lottoNumber.*;
import lotto.exception.lottoPrice.InvalidThousandUnitException;
import lotto.exception.lottoPrice.MinimumPriceException;
import lotto.exception.lottoPrice.NullPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void 로또금액_공백이면_예외_테스트(){
        String input = "";
        assertThatThrownBy(()->validator.isValidPrice(input))
                .isInstanceOf(NullPriceException.class)
                .hasMessage("금액은 null일 수 없습니다.");
    }

    @Test
    void 로또금액_1000원_미만_예외_테스트(){
        String input = "999";
        assertThatThrownBy(()->validator.isValidPrice(input))
                .isInstanceOf(MinimumPriceException.class)
                .hasMessage("최소 금액은 1,000원 이상이어야 합니다.");
    }

    @Test
    void 로또금액_1000단위가_아니면_예외_테스트(){
        String input = "2500";
        assertThatThrownBy(()->validator.isValidPrice(input))
                .isInstanceOf(InvalidThousandUnitException.class)
                .hasMessage("1,000원 단위의 금액만 입력 가능합니다.");
    }

    @Test
    void 로또번호_공백_예외_테스트(){
        String input = "";
        assertThatThrownBy(()->validator.isValidLottoNumbers(input))
                .isInstanceOf(NullLottoNumberException.class)
                .hasMessage("로또 번호는 null 일 수 없습니다.");
    }

    @Test
    void 로또번호_구분자가_없을때_예외_테스트(){
        String input = "123456";
        assertThatThrownBy(()->validator.isValidLottoNumbers(input))
                .isInstanceOf(NotFoundDelimiterException.class)
                .hasMessage("로또 번호는 쉼표(,)로 구분되어야 합니다.");
    }

    @Test
    void 로또번호_하나라도_숫자가_아니면_예외_테스트(){
        String input = "1,2,a,4,5 ,6";
        assertThatThrownBy(()->validator.isValidLottoNumbers(input))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage("로또 번호는 숫자여야 합니다");
    }

    @Test
    void 로또번호_1미만_45초과_예외_테스트(){
        String input = "1,2,3,4 ,5,46";
        assertThatThrownBy(()->validator.isValidLottoNumbers(input))
                .isInstanceOf(OutOfRangeNumberException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다");
    }

    @Test
    void 로또번호_개수_6개_아닐때_예외_테스트(){
        String input = "1,2,3,4,5, 6,7";
        assertThatThrownBy(()->validator.isValidLottoNumbers(input))
                .isInstanceOf(InvalidLottoCountException.class)
                .hasMessage("로또 번호는 6개여야 합니다");
    }

    @Test
    void 로또번호_중복된_수_있을때_예외_테스트(){
        String input = "1,1 ,2,3,4, 5";
        assertThatThrownBy(()->validator.isValidLottoNumbers(input))
                .isInstanceOf(DuplicatedNumberException.class)
                .hasMessage("로또 번호는 중복이 될 수 없습니다.");
    }





}
