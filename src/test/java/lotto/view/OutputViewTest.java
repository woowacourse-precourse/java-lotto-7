package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

  private final OutputView outputView = new OutputView();

  @DisplayName("로또 발행 결과를 출력한다")
  @Test
  void 로또_발행_결과를_출력한다() {
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

    outputView.printLottos(lottos);

    System.setOut(originalOut);

    String output = outputStreamCaptor.toString().trim();
    String[] lines = output.split(System.lineSeparator());

    assertEquals(ticketCount + "개를 구매했습니다.", lines[0]);

    for (int i = 1; i <= ticketCount; i++) {
      String line = lines[i];
      assertTrue(line.matches("\\[[\\d,\\s]+\\]"), "로또 번호 형식이 올바르지 않습니다.");
    }
  }

  @DisplayName("당첨 결과를 출력한다")
  @Test
  void 당첨_결과를_출력한다() {
    Result result = new Result();
    result.addRank(Rank.FIFTH);

    BigDecimal purchaseAmount = BigDecimal.valueOf(8000);

    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStreamCaptor));

    outputView.printResult(result, purchaseAmount);

    System.setOut(originalOut);

    String output = outputStreamCaptor.toString().trim();
    String[] lines = output.split(System.lineSeparator());

    assertEquals("당첨 통계", lines[0]);
    assertEquals("---", lines[1]);
    assertEquals("3개 일치 (5,000원) - 1개", lines[2]);
    assertEquals("4개 일치 (50,000원) - 0개", lines[3]);
    assertEquals("5개 일치 (1,500,000원) - 0개", lines[4]);
    assertEquals("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개", lines[5]);
    assertEquals("6개 일치 (2,000,000,000원) - 0개", lines[6]);
    assertTrue(lines[7].startsWith("총 수익률은 "), "수익률 출력 형식이 올바르지 않습니다.");
  }
}
