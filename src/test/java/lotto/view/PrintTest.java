package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.Lotto;
import lotto.domain.Handler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrintTest {
  private Input input;
  private Handler handler;
  private Print print;
  private int request;


  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outputStream));
  }

  public InputStream setReadLine(String readLine) {
    return new ByteArrayInputStream(readLine.getBytes());
  }

  @DisplayName("사용자 입력을 요청받은만큼 로또를 발행하여 응답하면 응답 결과를 출력한다")
  @Test
  public void printGeneratedTest() throws Exception{
    // given : 사용자가 구매 금액을 입력하면
    String readLine = "8000";
    this.input = new Input(readLine);
    System.setIn(setReadLine(readLine));

    // 로또 발행 수를 요청한다
    int amount = input.readAmount();
    this.request = input.getLottoCounts(amount);
    this.handler = new Handler(request);
    // 출력값 예시
    String expect = "[8, 21, 23, 41, 42, 43]\n" +
    "[3, 5, 11, 16, 32, 38\n" +
        "[7, 11, 16, 35, 36, 44]\n" +
        "[1, 8, 11, 31, 41, 42]\n" +
        "[13, 14, 16, 38, 42, 45]\n" +
        "[7, 11, 30, 40, 42, 43]\n" +
        "[2, 13, 22, 32, 38, 45]\n" +
        "[1, 3, 5, 14, 22, 45]";

    // when :입력 값에 기반하여 로또수를 요청하고
    int lottoCounts = input.getLottoCounts(amount);
    // 요청만큼 로또를 발행한 다음
    List<Integer> generated = handler.generateLotto();
    // 로또 발행 결과를 전달함으로써 요청값에 응답한다
    Lotto lotto = new Lotto(generated);
    List<List<Integer>> lottoResponse = lotto.responseLottoCounts(request);
    // 실제 출력을 로또수만큼 반복한다
    Print print = new Print(handler, input, lotto);
    print.printGenerated(lottoResponse);
    // 예시와 실제값 검증
    assertEquals(expect.trim(), outputStream.toString().trim());

  }

  /**
   * PrintTest > 당첨 번호 / 보너스 번호 비교 결과를 조회하여 각각 당첨 통계와 수익률을 출력하고 애플리케이션 종료 FAILED
   *     java.util.NoSuchElementException at PrintTest.java:29
   */
  // 이 테스트는 쪼개야 하는건가 아니면 함께 출력하기 위해 통합해야 하는건가..???
  @DisplayName("당첨 번호 / 보너스 번호 비교 결과를 조회하여 각각 당첨 통계와 수익률을 출력하고 애플리케이션 종료")
  @Test
  void printRevenueTest() throws Exception{
    // 일치성 결과 예시
    String givenResult = "3개 일치 (5,000원) - 1개\n" +
        "4개 일치 (50,000원) - 0개\n" +
        "5개 일치 (1,500,000원) - 0개\n" +
        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
        "6개 일치 (2,000,000,000원) - 0개";

    // 수익률 결과 예시
    String givenRevenue = "총 수익률은 62.5%입니다.";

    // when
    int amount = input.readAmount();
    int lottoCounts = input.getLottoCounts(amount);
    // 입력 값에 기반하여 요청을 전달하고
    List<Integer> generated = handler.generateLotto();
    String winningNumbers = input.readWinning();
    List<Integer> winning = handler.getWinning(winningNumbers);
    int bonus = handler.getBonus();
    Lotto lotto = new Lotto(generated);
    // 실제 일치성 결과 조회
    String actualResult = handler.compareNumbersResult(lotto.responseLottoCounts(request), winning, bonus);

    // 실제 수익률 결과 조회
    double revenue = handler.valueationRevenue(actualResult, amount); //  java.util.regex.PatternSyntaxException at PrintTest.java:101

    String actual = handler.getResult(revenue);

    // 실제 일치성 결과 출력
//    print.printResult(actualResult);
    // 실제 수익률 결과 출력
//    print.printRevenue(actualRevenue);

    assertEquals(givenRevenue, actualResult);
  }


}