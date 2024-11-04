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
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int bonusNumber = 4;
        Result expect = Result.valueOf(3, 1);

        assertEquals(comparator.compareLotto(lotto, winningNumbers, bonusNumber), expect);
    }

    @DisplayName("로또들의 결과를 반환한다")
    @Test
    void 로또들의_결과를_반환한다() {
        Comparator comparator = new Comparator();
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        lottos.add(lotto1);
        lottos.add(lotto2);

        List<Result> expect = new ArrayList<>();
        Result result1 = Result.valueOf(3, 1);
        Result result2 = Result.valueOf(4, 0);
        expect.add(result1);
        expect.add(result2);

        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int bonusNumber = 4;

        assertEquals(comparator.compareLottos(lottos, winningNumbers, bonusNumber), expect);
    }
}