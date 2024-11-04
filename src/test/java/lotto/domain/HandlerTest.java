package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.view.InputTest;
import lotto.view.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandlerTest {
  private Handler handler;
  private InputTest inputTest;
  private Input input;

  @BeforeEach
  void setUp() throws Exception {
    // 사용자가 구매 금액을 입력하면
    this.input = new Input();
    String readLine = "14000";
    System.setIn(setReadLine(readLine));

    // 로또 발행 수를 요청한다
    int amount = input.readAmount();
    int request = input.getLottoCounts(amount);
    handler = new Handler(request);
  }

  private InputStream setReadLine(String readLine) {
    return new ByteArrayInputStream(readLine.getBytes());
  }

  /**
   * HandlerTest > 사용자 입력 후 로또를 요청 수만큼 발행했는지 확인한다 FAILED
   *     java.util.NoSuchElementException at HandlerTest.java:31
   * @throws Exception
   */
  @DisplayName("사용자 입력 후 로또를 요청 수만큼 발행했는지 확인한다")
  @Test
  public void generateLottoTest() throws Exception{
      //given
    int expectGenerated = 14;
    int givenRequest = input.getLottoCounts(expectGenerated);

    // when
    List<List<Integer>> model = new ArrayList<>();
    for (int i = 0; i < expectGenerated; i++) {
      List<Integer> generated = handler.generateLotto(givenRequest);
      model.add(generated);
    }


    int actualGenerated = model.size();
    assertEquals(expectGenerated, actualGenerated);
  }

  /**
   * HandlerTest > 입력받은 당첨번호를 쉼표, 공백 구분자와 정수를 분리한다 FAILED
   *     java.util.NoSuchElementException at HandlerTest.java:31
   * @throws Exception
   */
  @DisplayName("입력받은 당첨번호를 쉼표, 공백 구분자와 정수를 분리한다")
  @Test
  void generateWinningTest() throws Exception{
    String given = "1,2,3,4,5,6";
    // split으로 두번 잘라서 배열에서 조회한다 (On²)
    // 스트림을 활용한다
    List<Integer> actual = Arrays.stream(given.split("\\s,"))
        .map(Integer::parseInt)
        .collect(Collectors.toList()); // NumberFormatException

    List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);

    assertEquals(expect, actual);

  }

  /**
   * HandlerTest > 내부적으로 구매 금액만큼의 로또를 발행하여 당첨 번호와 보너스 번호를 적절히 비교한다 FAILED
   *     org.opentest4j.AssertionFailedError at HandlerTest.java:99
   */
  @DisplayName("내부적으로 구매 금액만큼의 로또를 발행하여 당첨 번호와 보너스 번호를 적절히 비교한다")
  @Test
  void compareNumbersTest() {
    // given : 일치성 횟수 계산 결과 예시
    String given = "3개 일치 (5,000원) - 1개\n" +
        "4개 일치 (50,000원) - 0개\n" +
        "5개 일치 (1,500,000원) - 0개\n" +
        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
        "6개 일치 (2,000,000,000원) - 0개";

    // 구매 금액 만큼의 로또 수 조회
    int lottoCounts = input.getLottoCounts(8000);
    // 로또 수 만큼 로또 발행 후 전달
    List<Integer> generated = handler.generateLotto(lottoCounts);
    // 전달된 로또 결과 조회
//    List<Integer> actualLotto = new Lotto(generated);
    // 당첨 번호와 보너스 번호 조회
    List<Integer> winning = handler.getWinning();
    int bonus = handler.getBonus();
    // 실제 일치성 횟수 계산 결과 조회
    String actualResult = handler.compareNumbersResult(generated, winning, bonus);
    // 예시와 실제값 일치 여부 검증


    assertEquals(given, actualResult);
  }

  /**
   * HandlerTest > 비교한 결과를 토대로 총 수익률 계산한다 FAILED
   *     java.util.NoSuchElementException at HandlerTest.java:31
   */
  @DisplayName("비교한 결과를 토대로 총 수익률 계산한다")
  @Test
  void calculateRevenueTest() {
    // 총 수익률 예시
    double given = 62.5;
    String expect = "총 수익률은 62.5%입니다.";
    String resultExam = "3개 일치 (5,000원) - 1개\n" +
        "4개 일치 (50,000원) - 0개\n" +
        "5개 일치 (1,500,000원) - 0개\n" +
        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
        "6개 일치 (2,000,000,000원) - 0개";

    // 수익률 계산
    double revenue = handler.calculateRevenue(resultExam, input.readAmount());
    // 수익률 계산 결과 조회
    String actual = handler.getResult(revenue);
    // 검증
    assertEquals(expect, actual);
  }


}