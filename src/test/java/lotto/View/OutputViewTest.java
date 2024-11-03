package lotto.View;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest extends NsTest {

    @DisplayName("구입한 로또 티켓의 장수와 고정된 로또 번호를 올바르게 출력한다.")
    @Test
    void 구입한_로또_티켓_정보_출력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
