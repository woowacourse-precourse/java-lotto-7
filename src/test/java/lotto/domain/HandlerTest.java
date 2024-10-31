package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandlerTest {
  private Handler handler;


  @DisplayName("사용자 입력 후 로또를 발행하여 전달한다")
  @Test
  public void generateLottoTest() throws Exception{
      //given
//    System.setIn();
    List<Integer> actual = handler.generateLotto();
    //when

    //then
  }

}