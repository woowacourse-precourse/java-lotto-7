package lotto.util.changeDataType;

import lotto.util.ChangeDataType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeDataTypeTest {
    private final String[] correct = new String[]{"1", "2", "3", "4", "5", "6"};

    @Test
    void 문자열_배열_정수형_리스트_변환_테스트() {
        List<Integer> changeValues = ChangeDataType.stringArrayToIntegerList(correct);
        assertEquals(changeValues, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
