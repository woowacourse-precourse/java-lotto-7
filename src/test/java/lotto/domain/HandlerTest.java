package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import lotto.input.InputTest;
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
    inputTest = new InputTest();
    String readLine = "14000";
    System.setIn(setReadLine(readLine));
    int amount = input.readAmount();
    int request = input.getLottoCounts(amount);
    handler = new Handler(request);
  }

  private InputStream setReadLine(String readLine) {
    return new ByteArrayInputStream(readLine.getBytes());
  }

  @DisplayName("사용자 입력 후 로또를 발행하여 전달한다")
  @Test
  public void generateLottoTest() throws Exception{
      //given
    Input input = new Input();



    List<Integer> actual = handler.generateLotto();
    //when
    int amount = input.readAmount();
    int request = input.getLottoCounts(amount);

    List<Integer> given = List.of(1, 2, 3, 4, 5, 6);
    int expect = given.size();
    //then
    assertEquals(expect, actual.size());
  }

}