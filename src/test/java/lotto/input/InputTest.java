package lotto.input;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputTest {

  private Input input;

  @BeforeEach
  void setUp() throws Exception {
    this.input = new Input();
  }

  private InputStream setReadLine(String readLine) {
    return new ByteArrayInputStream(readLine.getBytes());
  }


  @DisplayName("애플리케이션을 실행하면 사용자가 로또 구매 금액을 입력하여 값을 읽는다")
  @Test
  void runApplicationTest() throws Exception{
    //given
    String given = "8000";
    System.setIn(setReadLine(given));

    //when
    // find why : 함수를 하나식 쪼갰더니 전체 테스트 실행에서 NoSuchElementException
    int actual = input.readAmount();
    int expect = 8000;
    //then
    assertEquals(expect, actual);
  }

  @DisplayName("입력된 금액에 따른 로또를 정확히 발행한다")
  @Test
  void getLottosCount() {

    // given
    System.setIn(setReadLine("14000"));
    int amount = input.readAmount();
    int actual = input.getLottoCounts(amount);

    // when
    int expect = 14;

    // then
    assertEquals(expect, actual);
  }

}