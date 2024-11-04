package lotto.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class RetainAllTest {
    @Test
    public void testRetainAll() {
        Set<Integer> lottoNumbers = new HashSet<>(Set.of(1, 7, 3, 4, 5));
        Set<Integer> winningNumberSet = new HashSet<>(Set.of(3, 4, 5, 6, 7));

        lottoNumbers.retainAll(winningNumberSet);
        int matchCount = lottoNumbers.size();

        Assertions.assertEquals(matchCount, 4);
    }
}
