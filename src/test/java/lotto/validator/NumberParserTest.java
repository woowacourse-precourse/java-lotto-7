package lotto.validator;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberParserTest {

    @Test
    @DisplayName("구분자로 입력된 문자열을 받아 숫자 리스트로 반환 실패시 Num")
    void testToNumbers() {
        String rightInput1 = "1,2,3,4,5,6";
        String rightInput2 = "1, 2, 3, 4, 5, 6";
        String wrongInput1 = "1,2,3,4,5,a";
        String wrpngInput2 = "";

        List<Integer> rightResult1 = Arrays.asList(1, 2, 3, 4, 5, 6);

        Assertions.assertEquals(rightResult1, NumberParser.toNumbers(rightInput1));
        Assertions.assertEquals(rightResult1, NumberParser.toNumbers(rightInput2));

        Assertions.assertThrows(NumberFormatException.class,
                () -> NumberParser.toNumbers(wrongInput1),
                "[ERROR] 숫자를 입력해 주세요.");

        Assertions.assertThrows(NumberFormatException.class,
                () -> NumberParser.toNumbers(wrpngInput2),
                "[ERROR] 숫자를 입력해 주세요.");
    }
}