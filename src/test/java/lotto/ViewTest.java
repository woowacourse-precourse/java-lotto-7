package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {

    private View view = new View();

    @Test
    void testPrintLottos() {
        // given
        View view = new View();
        List<List<Integer>> lottos = Arrays.asList(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12)
        );

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        view.printLottos(lottos);

        // then
        String expectedOutput = "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

}
