package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

  @Test
  @DisplayName("로또 발행 결과 출력 테스트")
  void 로또_발행_결과_출력_테스트() {
    OutputView outputView = new OutputView();
    int ticketCount = 3;
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < ticketCount; i++) {
      List<Integer> numbers = new ArrayList<>();
      for (int j = 1; j <= 6; j++) {
        numbers.add(j);
      }
      lottos.add(new Lotto(numbers));
    }

    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStreamCaptor));

    outputView.printLottoTickets(lottos);

    System.setOut(originalOut);

    String output = outputStreamCaptor.toString().trim();
    String[] lines = output.split(System.lineSeparator());

    assertEquals(ticketCount + "개를 구매했습니다.", lines[0]);

    for (int i = 1; i <= ticketCount; i++) {
      String line = lines[i];
      assertTrue(line.matches("\\[[\\d,\\s]+\\]"));
    }
  }
}
