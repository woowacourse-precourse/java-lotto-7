package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;


class MainControllerTest extends NsTest {


  @Test
  void 기능_테스트() {
    assertRandomUniqueNumbersInRangeTest(
            () -> {
              run("5000", "1,2,3,4,5,6", "45");
              assertThat(output()).contains(
                      "5개를 구매했습니다.",
                      "[1, 8, 11, 31, 41, 42]",
                      "[13, 14, 16, 38, 42, 45]",
                      "[7, 11, 30, 40, 42, 43]",
                      "[2, 3, 4, 5, 38, 45]",
                      "[1, 3, 5, 14, 22, 45]",
                      "3개 일치 (5,000원) - 1개",
                      "4개 일치 (50,000원) - 0개",
                      "5개 일치 (1,500,000원) - 0개",
                      "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                      "6개 일치 (2,000,000,000원) - 0개",
                      "총 수익률은 600100.0%입니다."
              );
            },
            List.of(1, 8, 11, 31, 41, 42),
            List.of(13, 14, 16, 38, 42, 45),
            List.of(7, 11, 30, 40, 42, 43),
            List.of(2, 3, 4, 5, 6, 45),
            List.of(1, 3, 5, 14, 22, 45)
    );

  }

  @Override
  public void runMain() {
    MainController controller = new MainController();

    controller.startLottoBusiness();
  }

}