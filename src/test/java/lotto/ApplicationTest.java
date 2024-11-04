package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치하는 개수를 반환한다.")
    void 로또_번호와_당첨_번호를_비교하여_일치하는_개수를_반환한다() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String[] winningNumbers = {"1", "2", "3", "7", "8", "9"};
        int bonusNumber = 10;

        Integer[] result = Lotto.calculateWinningStatus(lottoNumbers, winningNumbers, bonusNumber);

        assertThat(result[0]).isEqualTo(3); // 맞춘 개수 3개
        assertThat(result[1]).isEqualTo(0); // 보너스 번호 없음
    }

    @Test
    @DisplayName("일치 개수와 보너스 여부에 따라 당첨금을 반환한다.")
    void 일치_개수와_보너스_여부에_따라_당첨금을_반환한다() {
        assertThat(Lotto.checkLottoResult(3, false)).isEqualTo(5000);
        assertThat(Lotto.checkLottoResult(4, false)).isEqualTo(50000);
        assertThat(Lotto.checkLottoResult(5, true)).isEqualTo(2000000000);
        assertThat(Lotto.checkLottoResult(6, false)).isEqualTo(2000000000);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
