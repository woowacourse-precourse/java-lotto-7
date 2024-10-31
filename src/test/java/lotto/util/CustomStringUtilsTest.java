package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomStringUtilsTest {

    @DisplayName("문자열 출력 테스트")
    @Test
    void printStringLineFeed() {
        //given
        String str = "print";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        //when
        CustomStringUtils.printStringLineFeed(str);

        //then
        assertThat(outputStream.toString()).isEqualTo(str.concat("\n"));

        //원래의 System.out으로 변경
        System.setOut(originalOut);
    }
}