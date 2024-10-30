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
import java.util.List;
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

  @Test
  @DisplayName("당첨 번호 입력 안내 메시지 출력 테스트")
  public void 당첨_번호_안내_메시지_출력_테스트() {
    String input = "1,2,3,4,5,6\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = inputView.readWinningNumbers();

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("당첨 번호를 입력해 주세요."));
  }

  @Test
  @DisplayName("정상적인 당첨 번호 입력 및 검증 테스트")
  public void 정상적인_당첨_번호_입력_테스트() {
    String input = "1,2,3,4,5,6\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = inputView.readWinningNumbers();

    assertEquals(6, winningNumbers.size());
    assertEquals(List.of(1, 2, 3, 4, 5, 6), winningNumbers);
  }

  @Test
  @DisplayName("범위 내의 유효한 번호 입력 테스트")
  public void 범위_내_유효한_번호_입력_테스트() {
    String input = "7,14,22,33,39,45\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = inputView.readWinningNumbers();

    assertEquals(6, winningNumbers.size());
    assertEquals(List.of(7, 14, 22, 33, 39, 45), winningNumbers);
  }

  @Test
  @DisplayName("입력값이 비어있는 경우 예외 발생 테스트")
  public void 빈_입력값_예외_테스트() {
    String input = "\n1,2,3,4,5,6\n";
    provideInput(input);

    InputView inputView = new InputView();
    inputView.readWinningNumbers();

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 당첨 번호는 6개여야 합니다."));
  }

  @Test
  @DisplayName("6개 미만의 번호 입력 시 예외 발생 테스트")
  public void 번호_개수_부족_예외_테스트() {
    String input = "1,2,3\n1,2,3,4,5,6\n";
    provideInput(input);

    InputView inputView = new InputView();
    inputView.readWinningNumbers();

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 당첨 번호는 6개여야 합니다."));
  }

  @Test
  @DisplayName("6개 초과의 번호 입력 시 예외 발생 테스트")
  public void 번호_개수_초과_예외_테스트() {
    String input = "1,2,3,4,5,6,7\n1,2,3,4,5,6\n";
    provideInput(input);

    InputView inputView = new InputView();
    inputView.readWinningNumbers();

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 당첨 번호는 6개여야 합니다."));
  }

  @Test
  @DisplayName("범위를 벗어난 번호 입력 시 예외 발생 테스트")
  public void 번호_범위_벗어남_예외_테스트() {
    String input = "0,46,5,10,15,20\n1,2,3,4,5,6\n";
    provideInput(input);

    InputView inputView = new InputView();
    inputView.readWinningNumbers();

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."));
  }

  @Test
  @DisplayName("중복된 번호 입력 시 예외 발생 테스트")
  public void 중복된_번호_예외_테스트() {
    String input = "1,1,2,3,4,5\n1,2,3,4,5,6\n";
    provideInput(input);

    InputView inputView = new InputView();
    inputView.readWinningNumbers();

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 중복된 당첨 번호가 있습니다."));
  }

  @Test
  @DisplayName("숫자가 아닌 문자 포함 시 예외 발생 테스트")
  public void 숫자가_아닌_문자_포함_예외_테스트() {
    String input = "a,2,3,b,4,5\n1,2,3,4,5,6\n";
    provideInput(input);

    InputView inputView = new InputView();
    inputView.readWinningNumbers();

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 당첨 번호는 숫자여야 합니다."));
  }

  @Test
  @DisplayName("공백 포함된 입력 정상 처리 테스트")
  public void 공백_포함된_입력_정상_처리_테스트() {
    String input = "1, 2, 3 ,4 , 5 ,6\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = inputView.readWinningNumbers();

    assertEquals(6, winningNumbers.size());
    assertEquals(List.of(1, 2, 3, 4, 5, 6), winningNumbers);
  }

  @Test
  @DisplayName("숫자가 아닌 특수문자 포함 시 예외 발생 테스트")
  public void 특수문자_포함_예외_테스트() {
    String input = "1,2,3,4,@,6\n1,2,3,4,5,6\n";
    provideInput(input);

    InputView inputView = new InputView();
    inputView.readWinningNumbers();

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 당첨 번호는 숫자여야 합니다."));
  }

  @Test
  @DisplayName("보너스 번호 입력 안내 메시지 출력 테스트")
  public void 보너스_번호_안내_메시지_출력_테스트() {
    String input = "7\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = inputView.readBonusNumber(winningNumbers);

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("보너스 번호를 입력해 주세요."));
  }

  @Test
  @DisplayName("정상적인 보너스 번호 입력 및 검증 테스트")
  public void 정상적인_보너스_번호_입력_테스트() {
    String input = "7\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = inputView.readBonusNumber(winningNumbers);

    assertEquals(7, bonusNumber);
  }

  @Test
  @DisplayName("범위 내의 유효한 보너스 번호 입력 테스트")
  public void 범위_내_유효한_보너스_번호_입력_테스트() {
    String input = "45\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = inputView.readBonusNumber(winningNumbers);

    assertEquals(45, bonusNumber);
  }

  @Test
  @DisplayName("보너스 번호 입력값이 비어있는 경우 예외 발생 테스트")
  public void 보너스_번호_빈_입력값_예외_테스트() {
    String input = "\n7\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    inputView.readBonusNumber(winningNumbers);

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 보너스 번호를 입력해야 합니다."));
  }

  @Test
  @DisplayName("범위를 벗어난 보너스 번호 입력 시 예외 발생 테스트")
  public void 보너스_번호_범위_벗어남_예외_테스트() {
    String input = "46\n7\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    inputView.readBonusNumber(winningNumbers);

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."));
  }

  @Test
  @DisplayName("보너스 번호가 숫자가 아닌 문자 포함 시 예외 발생 테스트")
  public void 보너스_번호_숫자가_아닌_문자_포함_예외_테스트() {
    String input = "a\n7\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    inputView.readBonusNumber(winningNumbers);

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 보너스 번호는 숫자여야 합니다."));
  }

  @Test
  @DisplayName("보너스 번호 숫자가 아닌 특수문자 포함 시 예외 발생 테스트")
  public void 보너스_번호_특수문자_포함_예외_테스트() {
    String input = "@\n7\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    inputView.readBonusNumber(winningNumbers);

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 보너스 번호는 숫자여야 합니다."));
  }

  @Test
  @DisplayName("보너스 번호 공백 포함된 입력 정상 처리 테스트")
  public void 보너스_번호_공백_포함된_입력_정상_처리_테스트() {
    String input = " 7 \n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = inputView.readBonusNumber(winningNumbers);

    assertEquals(7, bonusNumber);
  }

  @Test
  @DisplayName("당첨 번호와 중복된 보너스 번호 입력 시 예외 발생 테스트")
  public void 당첨_번호_중복_보너스_번호_예외_테스트() {
    String input = "3\n7\n";
    provideInput(input);

    InputView inputView = new InputView();
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    inputView.readBonusNumber(winningNumbers);

    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."));
  }

  private void provideInput(String data) {
    System.setIn(new ByteArrayInputStream(data.getBytes()));
  }

  @Override
  protected void runMain() {

  }
}
