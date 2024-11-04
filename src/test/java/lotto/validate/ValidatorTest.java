package lotto.validate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ValidatorTest {

    @Test
    void validateParsingToInt_success() {
        //given
        String case1 = "1000";
        //when
        int validatedCase1 = Validator.validateParsingToInt(case1);
        //then
        Assertions.assertEquals(1000, validatedCase1);
    }
    @Test
    void validateParsingToInt_exception() {
        //given
        String case1 = "1,000";
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validateParsingToInt(case1));
    }
    @Test
    void validateDivided_ByUnit_success() {
        //given
        int case1 = 5000;
        //when
        Validator.validateDividedByUnit(case1);
        //then
        Assertions.assertDoesNotThrow(() -> Validator.validateDividedByUnit(case1));
    }
    @Test
    void validateDivided_ByUnit_exception() {
        //given
        int case1 = 5500;
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validateDividedByUnit(case1));
    }
    @Test
    void validationDelimiter_success() {
        //given
        String lottoNums = "1,2,3,4,5,6";
        String[] split = lottoNums.split(",");
        //when
        String[] strings = Validator.validationDelimiter(lottoNums);

        Assertions.assertEquals(split[0], strings[0]);
    }
    @Test
    void validationDelimiter_exception() {
        //given
        String lottoNums = "1,2,3,4,5:6";
        //when
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validationDelimiter(lottoNums));

    }
    @Test
    void validationInRange_success() {
        //given
        String lottoNums = "1,2,3,4,5,45";

        List<Integer> validationList = new ArrayList<>();

        //when
        String[] split = lottoNums.split(",");

        for (String numStr : split) {
            int num = Integer.parseInt(numStr);
            validationList.add(Validator.validationInRange(num));
        }

        //then
        Assertions.assertEquals(validationList.size(), 6);
    }

    @Test
    void validationInRange_exception() {
        //given
        int case1 = 46;

        //when then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validationInRange(case1)
        );
    }
    @Test
    void validationSize() {
        List<Integer> list = List.of(1, 2, 3);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validationSize(list));
    }
}