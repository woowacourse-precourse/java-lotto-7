package lotto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import lotto.model.Lotto;
import lotto.view.OutputView;
import lotto.view.OutputViewInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

  private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private OutputViewInterface outputView;
  private List<Lotto> lottos;

  @BeforeEach
  void setUp() {
    outputView = new OutputView();
    System.setOut(new PrintStream(outputStreamCaptor));
    lottos = List.of(
        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
        new Lotto(List.of(7, 8, 9, 10, 11, 12))
    );
  }

  @AfterEach
  void restoresStreams() {
    System.setOut(System.out);
  }

  @DisplayName("구매한 로또 수를 출력한다.")
  @Test
  void 구매_수량_출력이_정확해야한다() {
    outputView.printPurchaseCount(5);
    assertThat(outputStreamCaptor.toString().trim()).isEqualTo("5개를 구매했습니다.");
  }

  @DisplayName("생성된 로또 번호를 출력한다.")
  @Test
  void 생성된_로또_출력이_정확해야한다() {
    outputView.printGeneratedLottos(lottos);
    assertThat(outputStreamCaptor.toString().trim()).contains("[1, 2, 3, 4, 5, 6]",
        "[7, 8, 9, 10, 11, 12]");
  }

  @DisplayName("당첨 통계를 출력한다.")
  @Test
  void 당첨_결과_출력이_정확해야한다() {
    List<Integer> results = List.of(1, 2, 3, 4, 5);
    outputView.printWinningResults(results);
    assertThat(outputStreamCaptor.toString().trim()).contains(
        "당첨 통계",
        "---",
        "3개 일치 (5,000원) - 1개",
        "4개 일치 (50,000원) - 2개",
        "5개 일치 (1,500,000원) - 3개",
        "5개 일치, 보너스 볼 일치 (30,000,000원) - 4개",
        "6개 일치 (2,000,000,000원) - 5개");
  }

  @DisplayName("수익률을 출력한다.")
  @Test
  void 수익률_출력이_정확해야한다() {
    double expectedResult = 62.5;
    outputView.printYield(expectedResult);

    assertThat(outputStreamCaptor.toString().trim()).contains("총 수익률은 62.5%입니다.");
  }
}
