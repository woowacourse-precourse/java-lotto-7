package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

  @BeforeEach
  void setUp() throws Exception {
    // 사용자가 구매 금액을 입력하면

    String readLine = "14000";
    this.input = new Input(readLine);
    System.setIn(setReadLine(readLine));

    // 로또 발행 수를 요청한다
    int amount = input.readAmount();
    this.request = input.getLottoCounts(amount);
    handler = new Handler(request);
  }

  private InputStream setReadLine(String readLine) {
    return new ByteArrayInputStream(readLine.getBytes());
  }

  @AfterEach
  void printTest() {
    System.out.println("hello world!");
  }

  /**
   * PrintTest > 사용자 입력을 요청받은만큼 로또를 발행하여 응답하면 응답 결과를 출력한다 FAILED
   *     java.util.NoSuchElementException at PrintTest.java:29
   * @throws Exception
   */
  @DisplayName("사용자 입력을 요청받은만큼 로또를 발행하여 응답하면 응답 결과를 출력한다")
  @Test
  public void printGeneratedTest() throws Exception{
    // 출력값 예시
    String given = "8개를 구매했습니다.";
    // 사용자 입력을 읽으면
    int amount = input.readAmount();
    int lottoCounts = input.getLottoCounts(amount);
    // 입력 값에 기반하여 요청을 전달하고
    List<Integer> generated = handler.generateLotto(lottoCounts);
    // 요청받은만큼 로또를 발행한다
    Lotto lotto = new Lotto(generated);
    // 로또 발행 결과를 전달함으로써 요청값에 응답한다
    handler.getWinning();
    handler.getBonus();
    // 응답 내용을 출력한다
    String actualOutput = String.format("%d개를 구매했습니다.", lottoCounts);
    // 실제 출력값
    // 예시와 실제값 검증
    assertEquals(given, actualOutput); // org.opentest4j.AssertionFailedError at PrintTest.java:68

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
    List<Integer> actualLotto = handler.generateLotto(lottoCounts);

    List<Integer> winning = handler.getWinning();
    int bonus = handler.getBonus();
    // 실제 일치성 결과 조회
    String actualResult = handler.compareNumbersResult(actualLotto, winning, bonus);

    // 실제 수익률 결과 조회
    double revenue = handler.calculateRevenue(actualResult, amount); //  java.util.regex.PatternSyntaxException at PrintTest.java:101

    String actual = handler.getResult(revenue);

    // 실제 일치성 결과 출력
//    print.printResult(actualResult);
    // 실제 수익률 결과 출력
//    print.printRevenue(actualRevenue);

    assertEquals(givenRevenue, actualResult);
  }


}