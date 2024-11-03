package lotto.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 테스트하기 위해선 해당 메서드 default 또는 public 으로 변환 해주어야 함
 */
class InputViewImplTest {

    private InputViewImpl inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputViewImpl();
    }

    @Test
    void 번호_쉼표_구분_분리() {
        String input = "1, 2, 3, 4, 5, 6";
        String[] expected = {"1", " 2", " 3", " 4", " 5", " 6"};

        String[] result = inputView.splitNumbers(input);

        assertArrayEquals(expected, result);
    }

    @Test
    public void 문자열_정수_변환() {
        String[] numberStrings = {"1", " 2", "3", " 4", "5 ", " 6"};
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> result = inputView.convertStringsToIntegers(numberStrings);

        assertEquals(expected, result);
    }
}