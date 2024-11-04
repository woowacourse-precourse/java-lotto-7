package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("buyLotto 단위 테스트")
    @Test
    void buyLotto_기능_테스트() {
        assertThat(Application.buyLotto("7000")).isEqualTo(7);
    }

    @DisplayName("금액 입력이 1,000원 단위가 아닐 때 예외 처리")
    @Test
    void buyLotto_예외_1000원_단위() {
        assertThatThrownBy(() -> Application.buyLotto("1001")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("parseWinningNumber 단위 테스트")
    @Test
    void parseWinningNumber_기능_테스트() {
        assertThat(Application.parseWinningNumber("1,2,3,4,5,6")).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("drawLotto 단위 테스트")
    @Test
    void drawLotto_기능_테스트() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15)));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        assertThat(Application.drawLotto(lottos, winningLotto, bonusNumber)).isEqualTo(Map.of(
                "FIFTH", 1,
                "FOURTH", 0,
                "THIRD", 0,
                "SECOND", 1,
                "FIRST", 1));
    }

    @DisplayName("calProfitRate_단위_테스트")
    @Test
    void calProfitRate_기능_테스트() {
        Map<String, Integer> lotto1 = Map.of(
                "FIFTH", 1,
                "FOURTH", 0,
                "THIRD", 0,
                "SECOND", 0,
                "FIRST", 0);
        int lottoPieces1 = 10;

        Map<String, Integer> lotto2 = Map.of(
                "FIFTH", 0,
                "FOURTH", 1,
                "THIRD", 0,
                "SECOND", 0,
                "FIRST", 0);
        int lottoPieces2 = 10;

        assertThat(Application.calProfitRate(lotto1, lottoPieces1)).isEqualTo(50);
        assertThat(Application.calProfitRate(lotto2, lottoPieces2)).isEqualTo(500);
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
