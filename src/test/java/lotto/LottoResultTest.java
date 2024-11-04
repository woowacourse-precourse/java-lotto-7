package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest extends NsTest {
    @DisplayName("로또 2등 당첨에 대한 기능 테스트")
    @Test
    void 로또2등_당첨에_대한_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "[3, 5, 11, 16, 32, 38]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1500000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 7),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}