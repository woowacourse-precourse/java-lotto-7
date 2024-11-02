package validator;

import lotto.validator.LottoNumbersValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumbersValidatorTest {
    private LottoNumbersValidator lottoNumbersValidator;
    @BeforeEach
    void    setUp() {
        lottoNumbersValidator = new LottoNumbersValidator();
    }

    @Test
    void    로또번호_비정상입력_테스트() {
        List<String> errorLottoNumbersInputs = new ArrayList<>();

        errorLottoNumbersInputs.add("1.2.3.4");
        errorLottoNumbersInputs.add("a.b.c.d");
        errorLottoNumbersInputs.add("1, 2, 3, 4,");
        errorLottoNumbersInputs.add(",1,2,3,4");
        errorLottoNumbersInputs.add("1,2,3,,4");
        errorLottoNumbersInputs.add("1,2,3,4,");
        errorLottoNumbersInputs.add("1,2,3,4");
        errorLottoNumbersInputs.add("1,2,3,4,5");
        errorLottoNumbersInputs.add("1,2,3,4,5,6,7");
        errorLottoNumbersInputs.add("46,1,2,3,4,5");
        errorLottoNumbersInputs.add("1,1,2,3,4,5");
        errorLottoNumbersInputs.forEach((lottoNumbersInput) -> {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            lottoNumbersValidator.validate(lottoNumbersInput))
                            .isInstanceOf(IllegalArgumentException.class));
        });
    }
}
