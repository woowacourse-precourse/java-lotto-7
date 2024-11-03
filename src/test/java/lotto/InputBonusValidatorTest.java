package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputBonusValidatorTest {

    @DisplayName("당첨 번호와 보너스 번호 중복 에러 테스트")
    @Test
    void tt() {
        List<Integer> winningnumbers = Arrays.asList(1,2,3,4,5,6);
        String bonusNumber = "6";

        assertThatThrownBy(() -> new InputBonusValidator(bonusNumber)
                .checkSameNumberInWinningNumber(winningnumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("보너스 번호 범위 테스트")
    @ParameterizedTest
    @ValueSource()
    void bonusNumberRangeTest() {

    }

}