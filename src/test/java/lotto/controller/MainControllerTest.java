package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;


class MainControllerTest extends NsTest {
    private static final List<Integer> LOTTO_NUMBERS1 = List.of(1, 8, 11, 31, 41, 42);
    private static final List<Integer> LOTTO_NUMBERS2 = List.of(13, 14, 16, 38, 42, 45);
    private static final List<Integer> LOTTO_NUMBERS3 = List.of(2, 3, 4, 5, 6, 45);
    private static final List<Integer> LOTTO_NUMBERS4 = List.of(1, 3, 5, 14, 22, 45);

    private void runTest() {
        run("4000", "1,2,3,4,5,6", "45");
        assertOutputContains();
    }

    private void assertOutputContains() {
        assertThat(output()).contains(
                "4개를 구매했습니다.",
                LOTTO_NUMBERS1.toString(),
                LOTTO_NUMBERS2.toString(),
                LOTTO_NUMBERS3.toString(),
                LOTTO_NUMBERS4.toString(),
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 750,125.0%입니다."
        );
    }

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                this::runTest,
                LOTTO_NUMBERS1,
                LOTTO_NUMBERS2,
                LOTTO_NUMBERS3,
                LOTTO_NUMBERS4
        );
    }


    @Override
    public void runMain() {
        MainController controller = new MainController();

        controller.startLottoBusiness();
    }

}