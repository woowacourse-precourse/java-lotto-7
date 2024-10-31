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


  @DisplayName("애플리케이션을 실행하면 사용자가 로또 구매 금액을 입력하여 해당 금액만큼의 로또가 발행 수를 획득한다")
  @Test
  public void runApplicationTest() throws Exception{
    //given
    String given = "8000";
    System.setIn(setReadLine(given));

    //when
    int actual = input.readAmount();
    int expect = 8;
    //then
    assertEquals(expect, actual);
  }

}