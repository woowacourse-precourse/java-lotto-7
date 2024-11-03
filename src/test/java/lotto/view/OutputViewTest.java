package lotto.view;

import lotto.entity.Lotto;
import lotto.entity.Lottos;
import lotto.enums.NotificationMessage;
import lotto.enums.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("로또 구매 개수와 번호 출력 테스트")
    void displayLottos() {
        // Given
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));

        // When
        OutputView.printLottos(lottos);

        // Then
        String expectedOutput = NotificationMessage.PURCHASED_LOTTOS.format(2) + "\n" +
                "[1, 2, 3, 4, 5, 6]\n" +
                "[7, 8, 9, 10, 11, 12]\n" +
                NotificationMessage.DIVIDER.getMessage();

        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }
}
