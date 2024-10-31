package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.Handler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrintTest {
  private Input input;
  private Handler handler;
  private Print print;

  @BeforeEach
  void setUp() throws Exception {

  }
  @AfterEach
  void printTest() {
    System.out.println("hello world!");
  }

  @DisplayName("사용자 입력을 요청받은만큼 로또를 발행하여 응답하면 응답 결과를 출력한다")
  @Test
  public void printGeneratedTest() throws Exception{
      //given

      //when

      //then
  }
}