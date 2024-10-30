package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String PURCHASE_AMOUNT = (Randoms.pickUniqueNumbersInRange(1, 50, 1).getFirst() * 1000 + "");

    // MARK: - read purchase amount test
    @DisplayName("구매 금액에 정상 금액을 입력했을 경우")
    @Test
    void readPurchaseAmountSuccessTest() {
        assertSimpleTest(() -> {
            runException(PURCHASE_AMOUNT);
            assertThat(output()).doesNotContain(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매 금액에 1000원보다 작은 금액을 입력했을 경우")
    @Test
    void readPurchaseAmountFailTest1() {
        assertSimpleTest(() -> {
            runException("100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매 금액에 문자를 입력했을 경우")
    @Test
    void readPurchaseAmountFailTest2() {
        assertSimpleTest(() -> {
            runException("1000j", PURCHASE_AMOUNT);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매 금액에 1000원 단위가 아닌 값을 입력했을 경우")
    @Test
    void readPurchaseAmountFailTest3() {
        assertSimpleTest(() -> {
            runException("1200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    // MARK: - buy lottos test
    @DisplayName("로또를 정상적으로 구매했을 경우")
    @Test
    void buyLottosSuccessTest() {
        assertSimpleTest(() -> {
            runException(PURCHASE_AMOUNT);
            assertThat(output()).contains("개를 구매했습니다.");
        });
    }

    // MARK: - read winning numbers test
    @DisplayName("당첨 번호를 정상적으로 입력했을 경우")
    @Test
    void readWinningNumbersSuccessTest() {
        assertSimpleTest(() -> {
            runException(PURCHASE_AMOUNT, "1,2,3,4,5,6");
            assertThat(output()).doesNotContain(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 범위를 벗어났을 경우")
    @Test
    void readWinningNumbersFailTest1() {
        assertSimpleTest(() -> {
            runException(PURCHASE_AMOUNT, "60,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 숫자가 아닌 경우")
    @Test
    void readWinningNumbersFailTest2() {
        assertSimpleTest(() -> {
            runException(PURCHASE_AMOUNT, "a,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 6개가 아닌 경우")
    @Test
    void readWinningNumbersFailTest3() {
        assertSimpleTest(() -> {
            runException(PURCHASE_AMOUNT, "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우")
    @Test
    void readWinningLottoBonusNumberFailTest1() {
        assertSimpleTest(() -> {
            runException(PURCHASE_AMOUNT, "1,2,3,4,5,6", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    // ---

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
