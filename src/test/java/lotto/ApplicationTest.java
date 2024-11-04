package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

//    @Test
//    void 기능_테스트() {
//        assertRandomUniqueNumbersInRangeTest(
//                () -> {
//                    run("8000", "1,2,3,4,5,6", "7");
//                    assertThat(output()).contains(
//                            "8개를 구매했습니다.",
//                            "[8, 21, 23, 41, 42, 43]",
//                            "[3, 5, 11, 16, 32, 38]",
//                            "[7, 11, 16, 35, 36, 44]",
//                            "[1, 8, 11, 31, 41, 42]",
//                            "[13, 14, 16, 38, 42, 45]",
//                            "[7, 11, 30, 40, 42, 43]",
//                            "[2, 13, 22, 32, 38, 45]",
//                            "[1, 3, 5, 14, 22, 45]",
//                            "3개 일치 (5,000원) - 1개",
//                            "4개 일치 (50,000원) - 0개",
//                            "5개 일치 (1,500,000원) - 0개",
//                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
//                            "6개 일치 (2,000,000,000원) - 0개",
//                            "총 수익률은 62.5%입니다."
//                    );
//                },
//                List.of(8, 21, 23, 41, 42, 43),
//                List.of(3, 5, 11, 16, 32, 38),
//                List.of(7, 11, 16, 35, 36, 44),
//                List.of(1, 8, 11, 31, 41, 42),
//                List.of(13, 14, 16, 38, 42, 45),
//                List.of(7, 11, 30, 40, 42, 43),
//                List.of(2, 13, 22, 32, 38, 45),
//                List.of(1, 3, 5, 14, 22, 45)
//        );
//    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 빈_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Application.validateInput(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE + " 입력값이 비어 있습니다");
        });
    }

    @Test
    void 공백_포함_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Application.validateInput("1 2 3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE + " 입력에 공백이 포함되어 있습니다");
        });
    }

    @Test
    void 최소금액_미만_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Application.validatePurchaseCost(-1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE + " 로또 구입 금액은 최소 1000원 이상이어야 합니다");
        });
    }

    @Test
    void 구매금액_단위_미만_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Application.validatePurchaseCost(10500))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE + " 로또 구입 금액은 1000원 단위로 입력해야 합니다");
        });
    }

    @Test
    void 로또_발급_테스트() {
        assertSimpleTest(() -> {
            run("8000");
            String result = output();

            // 구매한 로또 개수가 올바르게 출력되는지 확인
            assertThat(result).contains("8개를 구매했습니다.");

            // 로또 번호가 모두 오름차순으로 정렬되어 있는지 확인
            String[] lines = result.split("\n");
            for (String line : lines) {
                if (line.startsWith("[") && line.endsWith("]")) {
                    String numbers = line.substring(1, line.length() - 1); // 대괄호 제거
                    String[] numArray = numbers.split(", ");

                    for (int i = 0; i < numArray.length - 1; i++) {
                        int current = Integer.parseInt(numArray[i]);
                        int next = Integer.parseInt(numArray[i + 1]);
                        assertThat(current).isLessThanOrEqualTo(next); // 오름차순 확인
                    }
                }
            }
        });
    }

    @Test
    void 당첨번호_부적절한_구분자_위치_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Application.validateWinningNumbers(",1,2,3,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE + " 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
        });
    }

    @Test
    void 당첨번호_개수_불일치_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Application.validateWinningNumbers("1,2,3,4,5,6,7"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE + " 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
        });
    }

    @Test
    void 보너스번호가_범위를_벗어났을때_예외_테스트() {
        assertThatThrownBy(() -> Application.validateBonusNumber("50", WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스번호가_당첨번호와_중복될떄_예외_테스트() {
        assertThatThrownBy(() -> Application.validateBonusNumber("3", WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
