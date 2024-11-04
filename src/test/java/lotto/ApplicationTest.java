package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static final int LOTTO_RANGE_MIN = 1;
    public static final int LOTTO_RANGE_MAX = 45;
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;


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
    void 예외_테스트_로또_가격_단위_오류() {
        assertSimpleTest(() -> {
            runException("1400");
            String message = String.format("[ERROR] 로또 가격(%d) 단위로 입력해주세요.", LOTTO_PRICE);
            assertThat(output()).contains(message);
        });
    }

    @Test
    void 예외_테스트_잘못된_정수_입력() {
        assertSimpleTest(() -> {
            runException("1000", "0,1,2,3,4,5");
            String message = String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_RANGE_MIN, LOTTO_RANGE_MAX);
            assertThat(output()).contains(message);
        });
    }

    @Test
    void 예외_테스트_로또_번호_갯수_오류() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3");
            String message = String.format("[ERROR] 로또 번호는 %d개여야 합니다.", LOTTO_NUMBER_COUNT);
            assertThat(output()).contains(message);
        });
    }

    @Test
    void 예외_테스트_로또_번호_중복_오류() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
