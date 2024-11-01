package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {

    @DisplayName("일치하는 번호의 개수가 올바른지 확인한다.")
    @Test
    void 일치하는_번호의_개수가_올바른지_확인한다() {
        Comparator comparator = new Comparator();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningNumbers = new Lotto(List.of(1,2,3,7,8,9));
        int bonusNumber = 4;
        Map<String, Integer> expect = new HashMap<>();
        expect.put("correct", 3);
        expect.put("bonus", 1);

        assertEquals(comparator.compareLotto(lotto, winningNumbers, bonusNumber), expect);
    }
}