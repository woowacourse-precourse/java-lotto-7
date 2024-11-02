package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class WinnerInputHandlerTest extends NsTest {
  private static final String ERROR_MESSAGE = "[ERROR]";

  @Test
  void 번호_입력에_음수값이_존재하면_에러가_발생한다() {
    assertSimpleTest(() -> {
      runException("1000", "1,2,3,4,5,-6");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 번호_입력에_숫자가_아닌값이_존재하면_에러가_발생한다() {
    assertSimpleTest(() -> {
      runException("2000", "1,2,3,4,5,hello");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 번호_입력을_6개로_확인할수_없다면_에러가_발생한다() {
    assertSimpleTest(() -> {
      runException("3000", "1,2,3");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 같은_값이_존재하면_에러가_발생한다() {
    assertSimpleTest(() -> {
      runException("4000", "1,1,7,8,9,10");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 입력이_올바르지_않으면_에러가_발생한다() {
    assertSimpleTest(() -> {
      runException("5000", ",10,,8,,7,1,2,3");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 범위를_초과한_번호가_존재하면_에러가_발생한다() {
    assertSimpleTest(() -> {
      runException("6000", "38,46,1,23,9,17");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Override
  protected void runMain() {
    Application.main(new String[]{});
  }
}