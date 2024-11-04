package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class IntegerParserTest {

    private IntegerParser integerParser;

    @BeforeEach
    public void setUp() {
        integerParser = new IntegerParser();
    }

    @Test
    @DisplayName("문자열 타입의 숫자 배열을 정수형 타입으로 반환시킬 수 있다.")
    void 문자열_파싱_테스트() throws Exception {
        // given
        String input = "1,2,3,4,5,6";

        // when
        List<Integer> output = integerParser.stringToIntegerList(input);

        // then
        assertThat(output).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
