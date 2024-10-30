package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {

  private final InputStream originalIn = System.in;
  private final PrintStream originalOut = System.out;

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

  @Test
  @DisplayName("구입 금액 안내 메세지를 출력한다")
  void 구입_금액_안내_메세지_출력_테스트() {
    String input = "8000\n";
    provideInput(input);

    InputView inputView = new InputView();
    inputView.readPurchaseAmount();

    String output = outputStreamCaptor.toString();

    assertTrue(output.contains("구입금액을 입력해 주세요."));
  }

  @Test
  @DisplayName("정상적인 금액 입력을 처리한다")
  void 정상적인_금액_입력_테스트() {
    String input = "8000\n";
    provideInput(input);

    InputView inputView = new InputView();
    BigDecimal purchaseAmount = inputView.readPurchaseAmount();

    assertEquals(new BigDecimal("8000"), purchaseAmount);
  }

  @Test
  @DisplayName("int 최대 범위 금액 입력을 처리한다")
  public void int_최대_범위_금액_입력_테스트() {
    // int 최대값보다 작은 1,000원 단위의 최대 금액
    String input = "2147483000\n";
    provideInput(input);

    InputView inputView = new InputView();
    BigDecimal purchaseAmount = inputView.readPurchaseAmount();

    assertEquals(new BigDecimal("2147483000"), purchaseAmount);
  }

  @Test
  @DisplayName("long 최대 범위 금액 입력을 처리한다")
  public void long_최대_범위_금액_입력_테스트() {
    // long 최대값보다 작은 1,000원 단위의 최대 금액
    String input = "9223372036854775000\n";
    provideInput(input);

    InputView inputView = new InputView();
    BigDecimal purchaseAmount = inputView.readPurchaseAmount();

    assertEquals(new BigDecimal("9223372036854775000"), purchaseAmount);
  }

  @Test
  @DisplayName("1000원 이하 금액 입력 시 오류 메시지 출력")
  void 천원_이하_입력_오류_메시지_테스트() {
    String input = "500\n1000\n";
    provideInput(input);

    InputView inputView = new InputView();
    BigDecimal purchaseAmount = inputView.readPurchaseAmount();

    String output = outputStreamCaptor.toString();

    assertTrue(output.contains("[ERROR] 구입 금액은 1000원 이상이어야 합니다."));
    assertEquals(new BigDecimal("1000"), purchaseAmount);
  }

  @Test
  @DisplayName("1,000원 단위로 나누어 떨어지지 않는 금액 입력 시 오류 메시지 출력")
  void 나누어떨어지지_않는_금액_입력_오류_메시지_테스트() {
    String input = "1300\n2000\n";
    provideInput(input);

    InputView inputView = new InputView();
    BigDecimal purchaseAmount = inputView.readPurchaseAmount();

    String output = outputStreamCaptor.toString();

    assertTrue(output.contains("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."));
    assertEquals(new BigDecimal("2000"), purchaseAmount);
  }

  @Test
  @DisplayName("정수가 아닌 값 입력 시 오류 메시지 출력")
  void 정수가_아닌_값_입력_오류_메시지_테스트() {
    String input = "8천원\n9000\n";
    provideInput(input);

    InputView inputView = new InputView();
    BigDecimal purchaseAmount = inputView.readPurchaseAmount();

    String output = outputStreamCaptor.toString();

    assertTrue(output.contains("[ERROR] 구입 금액은 숫자여야 합니다."));
    assertEquals(new BigDecimal("9000"), purchaseAmount);
  }

  @Test
  @DisplayName("음수 입력 시 오류 메시지 출력")
  void 음수_입력_오류_메시지_테스트() {
    String input = "-1000\n1000\n";
    provideInput(input);

    InputView inputView = new InputView();
    BigDecimal purchaseAmount = inputView.readPurchaseAmount();

    String output = outputStreamCaptor.toString();

    assertTrue(output.contains("[ERROR] 구입 금액은 1000원 이상이어야 합니다."));
    assertEquals(new BigDecimal("1000"), purchaseAmount);
  }

  private void provideInput(String data) {
    System.setIn(new ByteArrayInputStream(data.getBytes()));
  }

  @Override
  protected void runMain() {

  }
}
