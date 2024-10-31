package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

  private Input input;

  @BeforeEach
  void setUp() throws Exception {
    this.input = new Input();
  }

  public InputStream setReadLine(String readLine) {
    return new ByteArrayInputStream(readLine.getBytes());
  }


  @DisplayName("애플리케이션을 실행하면 사용자가 로또 구매 금액을 입력하여 값을 읽고 로또 발행 수량까지 요청한다")
  @Test
  void runApplicationTest() {
    //given
    String given = "8000";
    System.setIn(setReadLine(given));

    //when
    // find why : 함수를 하나식 쪼갰더니 전체 테스트 실행에서 NoSuchElementException
    int actualAmount = input.readAmount();
    int expectAmount = 8000;

    int actualRequest = input.getLottoCounts(actualAmount);
    int expectRequest = 8;
    //then
    assertEquals(expectAmount, actualAmount);
    assertEquals(expectRequest, actualRequest);
  }

//  @DisplayName("입력된 금액에 따른 로또를 정확히 발행한다")
//  @Test
//  void getLottosCount() {
//
//    // given
//    System.setIn(setReadLine("14000"));
//    int amount = input.readAmount();
//    int actual = input.getLottoCounts(amount);
//
//    // when
//    int expect = 14;
//
//    // then
//    assertEquals(expect, actual);
//  }

}