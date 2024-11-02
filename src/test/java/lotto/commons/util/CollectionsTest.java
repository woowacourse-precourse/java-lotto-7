package lotto.commons.util;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CollectionsTest {

    @Test
    void joinToString_with_separator_prefix_suffix_should_be_pass() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        // when
        String str = Collections.joinToString(list, ", ", "[", "]");
        // then
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6]", str);
    }

    @Test
    void sumOf_should_be_pass() {
        // given
        List<TestObject> objects = List.of(
                new TestObject(1),
                new TestObject(2),
                new TestObject(3)
        );
        // when
        BigDecimal sum = Collections.sumOf(objects, (it) -> BigDecimal.valueOf(it.value));
        // then
        Assertions.assertEquals(BigDecimal.valueOf(6), sum);
    }

    private record TestObject(Integer value) {}
}
