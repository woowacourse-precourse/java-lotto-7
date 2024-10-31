package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
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
    this.input = new Input();
    String readLine = "14000";
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

  @DisplayName("사용자 입력을 요청받은만큼 로또를 발행하여 응답하면 응답 결과를 출력한다")
  @Test
  public void printGeneratedTest() throws Exception{
      //given
    List<Integer> generated = handler.generateLotto(request);
    print.printGenerated(request);
    //when

      //then
  }

  @DisplayName("당첨 번호 / 보너스 번호 비교 결과를 조회하여 각각 당첨 통계와 수익률을 출력하고 애플리케이션 종료")
  @Test
  void printRevenueTest() throws Exception{

  }
}