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

   /* @Test
    void 번호_쉼표_구분_분리() {
        assertArrayEquals(
                new String[]{"1", " 2", " 3", " 4", " 5", " 6"},
                inputView.splitNumbers("1, 2, 3, 4, 5, 6")
        );
    }

    @Test
    public void 문자열_정수_변환() {
        assertEquals(
                List.of(1, 2, 3, 4, 5, 6),
                inputView.convertStringsToIntegers(new String[]{"1", " 2", "3", " 4", "5 ", " 6"})
        );
    }*/
}