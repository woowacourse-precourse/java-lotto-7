package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void 로또_번호_문자열을_구분자를_통해_정수_리스트로_변환() {
        String input = "1,2,3,4,5,6";

        List<Integer> numbers = Converter.convertToIntgerList(input);

        List<Integer> convertNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(numbers, convertNumbers);
    }
}