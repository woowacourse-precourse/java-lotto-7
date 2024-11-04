package lotto.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TreeSetTest {

    @Test
    void reverseOrder() {
        List<TreeSet<Integer>> sets = new ArrayList<>();
        sets.add(new TreeSet<>());
        sets.get(0).add(4);
        sets.get(0).add(2);

        sets.add(new TreeSet<>());
        sets.get(1).add(42);
        sets.get(1).add(32);
        TreeSet<Integer> firstSet = sets.get(0);
        Assertions.assertEquals(2, firstSet.first());
        Assertions.assertEquals(4, firstSet.last());

        TreeSet<Integer> secondSet = sets.get(1);
        Assertions.assertEquals(32, secondSet.first());
        Assertions.assertEquals(42, secondSet.last());

    }
}
