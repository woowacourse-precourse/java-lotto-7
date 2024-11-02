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

  @Test
  void 보너스번호가_당첨번호중_겹치는게_존재하면_에러가_발생한다() {
    assertSimpleTest(() -> {
      runException("7000", "1,2,3,4,5,6", "6");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 보너스번호가_숫자가_아니면_에러가_발생한다() {
    assertSimpleTest(() -> {
      runException("8000", "1,2,3,4,5,6", "숫자아님ㅎ");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 보너스번호의_범위가_초과하면_에러가_발생한다() {
    assertSimpleTest(() -> {
      runException("9000", "11,22,33,44,45,6", "46");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 보너스번호가_1보다_작으면_에러가_발생한다() {
    assertSimpleTest(() -> {
      runException("10000", "1,2,3,4,5,6", "-1");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Override
  protected void runMain() {
    Application.main(new String[]{});
  }
}