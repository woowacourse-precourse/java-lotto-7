package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.repository.LottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private final LottoRepository lottoRepository= LottoRepository.getInstance();

    @BeforeEach
    void setUp() {
        lottoRepository.findAllLottos().clear();
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

    @Test
    @DisplayName("입력한 당첨 번호와 보너스 번호가 중복되는 경우")
    void duplicateTest() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
        });
    }

    @Test
    @DisplayName("당첨 번호가 중복되는 경우")
    void duplicateTest2() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5", "7");
        });
    }

    @Test
    @DisplayName("당첨 번호를 6개 이하로 입력한 경우")
    void numberCountTest() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4", "6");
        });
    }

    @Test
    @DisplayName("1에서 45 사이의 숫자가 아닌 경우")
    void numberRangeTest() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,41,66,87", "6");
        });
    }

    @Test
    @DisplayName("1000원 미만의 돈을 입력한 경우")
    void moneyRangeTest() {
        assertSimpleTest(() -> {
            runException("200", "1,2,3,41,66,87", "6");
        });
    }

    @Test
    @DisplayName("1000원 단위가 아닌 경우")
    void moneyChangeTest() {
        assertSimpleTest(() -> {
            runException("21111", "1,2,3,41,66,87", "6");
        });
    }

    @Test
    @DisplayName("입력 공백")
    void blankInputTest() {
        assertSimpleTest(() -> {
            runException(" ", "1,2,3,41,66,87", "6");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
