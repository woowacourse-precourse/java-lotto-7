package lotto.utils;

import java.util.ArrayList;
import java.util.List;
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

    @ParameterizedTest
    @ValueSource(ints = {100,2222,333330,44444444})
    void testValidateDivisible(int value){
        int divisor = 1000;
        assertThatThrownBy(()->Validator.validateDivisible(value,divisor)).isInstanceOf(IllegalArgumentException.class);
        int validValue = (value / divisor) * divisor;

        Validator.validateDivisible(validValue,divisor);
    }

    @ParameterizedTest
    @ValueSource(ints = {46,-1,0,5000})
    void testValidateSpecificRange(int value){
        int start = 1;
        int end = 45;

        assertThatThrownBy(()->Validator.validateSpecificRange(value,start,end)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,7,8,9,150})
    void testValidateListSize(int listSize){
        int size= 6;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < listSize; ++i) {
            list.add(i);
        }
        assertThatThrownBy(()->Validator.validateListSize(list,size)).isInstanceOf(IllegalArgumentException.class);
        Validator.validateListSize(list,listSize);
    }

}
