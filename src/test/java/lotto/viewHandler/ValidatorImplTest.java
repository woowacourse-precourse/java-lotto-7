package lotto.viewHandler;

import lotto.viewHandler.exception.NotLottoNumberRange;
import lotto.viewHandler.exception.NotUnitPurchaseMoney;
import lotto.viewHandler.validator.validatorImpl.LottoNumberRangeValidator;
import lotto.viewHandler.validator.validatorImpl.LottoNumberSplit;
import lotto.viewHandler.validator.validatorImpl.LottoPurchaseUnitValidator;
import lotto.viewHandler.validator.validatorImpl.ParseInt;
import lotto.viewHandler.validator.ValidatorImpl;
import lotto.viewHandler.validator.validatorImpl.RemoveWhiteSpace;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorImplTest {
    private final ValidatorImpl validator;

    public ValidatorImplTest() {
        this.validator = new ValidatorImpl(
                new RemoveWhiteSpace(),
                new ParseInt(),
                new LottoNumberRangeValidator(),
                new LottoPurchaseUnitValidator(),
                new LottoNumberSplit()
        );
    }

    @Test
    void 로또_합격_번호_스페이스_확인() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> expect = List.of(1,2,3,4,5,6);
        List<Integer> result = validator.validateLottoNumbers(input);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 로또_구매_돈_확인() {
        String input = "10000";
        Integer expect = 10_000;
        Integer result = validator.validateMoney(input);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 로또_합격_번호_확인() {
        String input = "1,2,3,4,5,6";
        List<Integer> expect = List.of(1,2,3,4,5,6);
        List<Integer> result = validator.validateLottoNumbers(input);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 로또_보너스_번호_확인() {
        String input = "23";
        Integer expect = 23;
        Integer result = validator.validBonusLottoNumber(input);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 로또_숫자_범위_제외_확인() {
        String input = "1,2,3,4,5,46";

        assertThatThrownBy(() -> {
            validator.validateLottoNumbers(input);
        }).isInstanceOf(NotLottoNumberRange.class);
    }

    @Test
    void 로또_보너스_숫자_범위_제외_확인() {
        String input = "-1";

        assertThatThrownBy(() -> {
            validator.validBonusLottoNumber(input);
        }).isInstanceOf(NotLottoNumberRange.class);
    }

    @Test
    void 로또_구매_단위_제외_확인() {
        String input = "11101";

        assertThatThrownBy(() -> {
            validator.validateMoney(input);
        }).isInstanceOf(NotUnitPurchaseMoney.class);
    }
}