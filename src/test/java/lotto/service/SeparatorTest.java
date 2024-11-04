package lotto.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeparatorTest {

    private final Separator separator = new Separator();

    @Test
    void separate_숫자만_입력했을때_정상작동() {
        List<Integer> result = separator.separate("1,2,3,4,5,6");
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result);
    }

    @Test
    void separate_여러개의_공백을_포함한_입력일때_정상작동() {
        List<Integer> result = separator.separate(" 1 , 2 , 3 , 4 , 5 , 6 ");
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result);
    }

    @Test
    void separate_당첨번호가_여섯개가아니면_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            separator.separate("1,2,3");
        });
        assertEquals("[ERROR] 당첨 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    void trimInput_숫자가_아닐경우_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            separator.trimInput("abc");
        });
        assertEquals("[ERROR] 숫자로 입력해주세요", exception.getMessage());
    }

    @Test
    void trimInput_범위를_벗어난_숫자일때_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            separator.trimInput("50");
        });
        assertEquals("[ERROR] 로또 번호는 1부터 45까지입니다", exception.getMessage());
    }

    @Test
    void trimInput_정상적인_숫자일때_예외없음() {
        assertDoesNotThrow(() -> {
            int result = separator.trimInput("10");
            assertEquals(10, result);
        });
    }
}
