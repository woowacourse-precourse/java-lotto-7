package lotto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import lotto.model.Lotto;
import lotto.view.OutputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InOutTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private OutputHandler outputHandler;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        outputHandler = new OutputHandler();
    }

    @Test
    void testPrintLotto() {
        List<Integer> numbers = new ArrayList<>(List.of(5, 10, 15, 20, 25, 30));
        // given
        Lotto lotto = new Lotto(numbers);
        // when
        outputHandler.printLotto(lotto);
        // then
        assertEquals("[5, 10, 15, 20, 25, 30]", outputStreamCaptor.toString().trim());
    }

}
