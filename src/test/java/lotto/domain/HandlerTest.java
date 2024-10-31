package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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

}