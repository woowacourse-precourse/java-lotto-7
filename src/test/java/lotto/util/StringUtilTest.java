package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 문자열_양수_파싱_테스트(String strNum){
        Integer num = StringUtil.parseToPositiveInt(strNum);
        assertInstanceOf(Integer.class, num);
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "a", "0", "-1"})
    void 문자열_양수_파싱_테스트_실패(String strNum){
        assertThrows(
                IllegalArgumentException.class,
                () -> StringUtil.parseToPositiveInt(strNum)
        );
    }

}