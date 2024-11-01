package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {

    @DisplayName("로또의 결과를 반환한다")
    @Test
    void 로또의_결과를_반환한다() {
        Comparator comparator = new Comparator();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningNumbers = new Lotto(List.of(1,2,3,7,8,9));
        int bonusNumber = 4;
        Map<String, Integer> expect = new HashMap<>();
        expect.put("correct", 3);
        expect.put("bonus", 1);

        assertEquals(comparator.compareLotto(lotto, winningNumbers, bonusNumber), expect);
    }
    @DisplayName("로또들의 결과를 반환한다")
    @Test
    void 로또들의_결과를_반환한다() {
        Comparator comparator = new Comparator();
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,3,5,7,9,11));
        lottos.add(lotto1);
        lottos.add(lotto2);

        List<Map<String, Integer>> expect = new ArrayList<>();
        Map<String, Integer> result1 = new HashMap<>();
        result1.put("correct", 3);
        result1.put("bonus", 1);
        Map<String, Integer> result2 = new HashMap<>();
        result2.put("correct", 4);
        result2.put("bonus", 0);
        expect.add(result1);
        expect.add(result2);

        Lotto winningNumbers = new Lotto(List.of(1,2,3,7,8,9));
        int bonusNumber = 4;

        assertEquals(comparator.compareLottos(lottos, winningNumbers, bonusNumber), expect);
    }
}