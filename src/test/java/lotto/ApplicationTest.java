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

    @DisplayName("기본 기능 테스트")
    @Test
    void basic_test() {
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

    @DisplayName("발행 로또가 정렬되는지 확인")
    @Test
    void sort_test() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[40, 41, 42, 43, 44, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 100000000.0%입니다."
                    );
                },
                List.of(6, 5, 4, 3, 2, 1),
                List.of(45, 44, 43, 42, 41, 40)
        );
    }

    @DisplayName("구입 금액에 아무것도 넣지 않았을 때 예외 처리 확인")
    @Test
    void cost_is_blank() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입 금액이 숫자가 아닐 때 예외 처리 확인")
    @Test
    void cost_is_not_number() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입 금액이 음수일 때 예외 처리 확인")
    @Test
    void cost_is_negative() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입 금액이 1000으로 나누어지지 않을 때 예외 처리 확인")
    @Test
    void cost_is_not_divided() {
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호에 아무것도 넣지 않았을 때 예외 처리 확인")
    @Test
    void winning_numbers_are_blank() {
        assertSimpleTest(() -> {
            runException("8000", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 6개가 아닐 때 예외 처리 확인")
    @Test
    void winning_numbers_are_not_six() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 중복되었을 때 예외 처리 확인")
    @Test
    void winning_numbers_are_duplicated() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 1 ~ 45의 값이 아닐 때 예외 처리 확인")
    @Test
    void winning_numbers_are_out_of_range() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,99");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("8000", "-1,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호에 아무것도 넣지 않았을 때 예외 처리 확인")
    @Test
    void bonus_number_is_blank() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 1 ~ 45의 값이 아닐 때 예외 처리 확인")
    @Test
    void bonus_number_is_out_of_range() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "99");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 처리 확인")
    @Test
    void bonus_number_is_duplicated() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
