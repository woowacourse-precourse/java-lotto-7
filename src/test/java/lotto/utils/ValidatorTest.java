package lotto.utils;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc","1234~","00-11","#@-12"})
    void testValidateNumericString(String numericString){

        assertThatThrownBy(()->Validator.validateNumericString(numericString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-222222222222222222","1000000000000000000",})
    void testValidateIntRange(String numericString){

        assertThatThrownBy(()->Validator.validateIntRange(numericString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-2,-1000,0})
    void testValidatePositiveNumber(int number){

        assertThatThrownBy(()->Validator.validatePositiveNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ","\n","      \n", "\t  "})
    void testValidateEmtpyString(String blankString){

        assertThatThrownBy(()->Validator.validateBlankString(blankString)).isInstanceOf(IllegalArgumentException.class);
    }
}
