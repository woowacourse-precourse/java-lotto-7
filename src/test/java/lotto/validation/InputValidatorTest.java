package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void isNullOrBlank() {
        assertThat(InputValidator.isNullOrBlank(null)).isTrue();
        assertThat(InputValidator.isNullOrBlank(" ")).isTrue();
        assertThat(InputValidator.isNullOrBlank("")).isTrue();
        assertThat(InputValidator.isNullOrBlank("blabla")).isFalse();
    }

    @Test
    void isThousandUnit() {
        assertThat(InputValidator.isThousandUnit(1000)).isTrue();
        assertThat(InputValidator.isThousandUnit(2000)).isTrue();
        assertThat(InputValidator.isThousandUnit(1100)).isFalse();

    }

    @Test
    void isValidFormatForMoney() {
        assertThat(InputValidator.isValidFormatForMoney("1000")).isTrue();
        assertThat(InputValidator.isValidFormatForMoney("1000원")).isFalse();
        assertThat(InputValidator.isValidFormatForMoney("0")).isFalse();
        assertThat(InputValidator.isValidFormatForMoney("")).isFalse();
    }

    @Test
    void isValidFormatForLottoNumber() {
        assertThat(InputValidator.isValidFormatForLottoNumber("1,2,3,4,5,6")).isTrue();
        assertThat(InputValidator.isValidFormatForLottoNumber("1,2,3,4,5,a")).isFalse();
        assertThat(InputValidator.isValidFormatForLottoNumber("1:2:3:4:5:6")).isFalse();
    }

    @Test
    void isCountSix() {
        assertThat(InputValidator.isCountSix(new String[]{"1","2","3","4","5","6"})).isTrue();
        assertThat(InputValidator.isCountSix(new String[]{"1","2","3","4","5","6","7","8"})).isFalse();
        assertThat(InputValidator.isCountSix(new String[]{"1","2","3","4"})).isFalse();
    }

    @Test
    void isUniqueNumbers() {
        assertThat(InputValidator.isUniqueNumbers(new String[]{"1","2","3","4","5","6"})).isTrue();
        assertThat(InputValidator.isUniqueNumbers(new String[]{"1","2","3","3","5","6"})).isFalse();
    }

    @Test
    void isInRange() {
        assertThat(InputValidator.isInRange(new String[]{"1","2","3","4","5","6"})).isTrue();
        assertThat(InputValidator.isInRange(new String[]{"1","2","3","4","5","47"})).isFalse();

    }

    @Test
    void IsInRange() {
        assertThat(InputValidator.isInRange("1")).isTrue();
        assertThat(InputValidator.isInRange("0")).isFalse();
    }

    @Test
    void isNumeric() {
        assertThat(InputValidator.isNumeric("1")).isTrue();
        assertThat(InputValidator.isNumeric("asdd")).isFalse();
    }

    @Test
    void isUnique() {
        assertThat(InputValidator.isUnique("1", List.of(1, 2, 3, 4, 5, 6))).isFalse();
        assertThat(InputValidator.isUnique("7", List.of(1, 2, 3, 4, 5, 6))).isTrue();
    }
}