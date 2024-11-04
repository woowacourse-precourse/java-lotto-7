package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {

  private final InputStream originalIn = System.in;
  private final PrintStream originalOut = System.out;
  private final InputView inputView = new InputView();

  private ByteArrayOutputStream outputStreamCaptor;

  @BeforeEach
  public void setUp() {
    outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setIn(originalIn);
    System.setOut(originalOut);
    Console.close();
  }

  @DisplayName("구입 금액 입력 안내 메시지를 출력한다")
  @Test
  void 구입_금액_입력_안내_메시지를_출력한다() {
    String input = "8000\n";
    provideInput(input);

    inputView.readPurchaseAmount();

    String output = outputStreamCaptor.toString().trim();
    assertEquals("구입금액을 입력해 주세요.", output);
  }

  @DisplayName("당첨 번호 입력 안내 메시지를 출력한다")
  @Test
  void 당첨_번호_입력_안내_메시지를_출력한다() {
    String input = "1,2,3,4,5,6\n";
    provideInput(input);

    inputView.readWinningNumbers();

    String output = outputStreamCaptor.toString().trim();
    assertEquals("당첨 번호를 입력해 주세요.", output);
  }

  @DisplayName("보너스 번호 입력 안내 메시지를 출력한다")
  @Test
  void 보너스_번호_입력_안내_메시지를_출력한다() {
    String input = "7\n";
    provideInput(input);

    inputView.readBonusNumber();

    String output = outputStreamCaptor.toString().trim();
    assertEquals("보너스 번호를 입력해 주세요.", output);
  }

  @DisplayName("입력값이 null이거나 빈 문자열이면 예외가 발생한다")
  @Test
  void 입력값이_null_또는_빈_문자열이면_예외가_발생한다() {
    String input = "\n";
    provideInput(input);

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      inputView.readBonusNumber();
    });

    assertEquals("[ERROR] 입력이 필요합니다.", exception.getMessage());
  }

  private void provideInput(String data) {
    System.setIn(new ByteArrayInputStream(data.getBytes()));
  }

  @Override
  protected void runMain() {

  }
}
