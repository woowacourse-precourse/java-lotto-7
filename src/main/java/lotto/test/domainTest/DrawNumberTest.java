package lotto.test.domainTest;

import lotto.domain.DrawNumber;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DrawNumberTest {
    @Test
    public void testDraw() {
        List<Integer> drawnNumbers = new DrawNumber().draw();
        assertThat(new HashSet<>(drawnNumbers)).size().isEqualTo(drawnNumbers.size());
    }
}
