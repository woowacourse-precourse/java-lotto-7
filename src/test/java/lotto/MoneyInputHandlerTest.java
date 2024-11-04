package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class MoneyInputHandlerTest extends NsTest {
  private static final String ERROR_MESSAGE = "[ERROR]";

  @Test
  void 구입_금액이_음수이면_에러가_발생한다(){
    assertSimpleTest(() -> {
      runException("-4000");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 구입_금액이_0이면_에러가_발생한다(){
    assertSimpleTest(() -> {
      runException("0");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 구입_금액이_빈칸이면_에러가_발생한다(){
    assertSimpleTest(() -> {
      runException("\n");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 구입_금액에_숫자가_아닌_다른값이면_에러가_발생한다(){
    assertSimpleTest(() -> {
      runException("안녕");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 구입_금액이_1000으로_떨어지지_않으면_에러가_발생한다(){
    assertSimpleTest(() -> {
      runException("4999");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Override
  protected void runMain() {
    Application.main(new String[]{});
  }
}
