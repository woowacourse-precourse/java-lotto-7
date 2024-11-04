package lotto.util.validationTest;

import lotto.enumValue.CommonMessage;
import lotto.validation.BonusNumberValidation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BonusNumberValidationTest {
    private final List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    void 당첨_번호_보너스_번호_중복_예외_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BonusNumberValidation.duplicateChecker(1, lottoNumbers))
                .withMessageContaining(CommonMessage.ERROR.getMessange());
    }
}
