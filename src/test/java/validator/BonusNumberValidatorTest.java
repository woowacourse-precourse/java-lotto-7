package validator;

import lotto.validator.BonusNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BonusNumberValidatorTest {
    private BonusNumberValidator bonusNumberValidator;
    @BeforeEach
    void    setUp() {
        bonusNumberValidator = new BonusNumberValidator();
    }

    @Test
    void    보너스번호_비정상입력_테스트() {
        List<String> errorBonusNumberInputs = new ArrayList<>();
        String[] exampleLottoNumbers = {"1","2","3","4","5","6"};

        errorBonusNumberInputs.add("a");
        errorBonusNumberInputs.add(",");
        errorBonusNumberInputs.add("-2");
        errorBonusNumberInputs.add("++3");
        errorBonusNumberInputs.add("1");
        errorBonusNumberInputs.forEach((bonusNumberInput) -> {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            bonusNumberValidator.validate(bonusNumberInput, exampleLottoNumbers))
                            .isInstanceOf(IllegalArgumentException.class));
        });
    }
}
