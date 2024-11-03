package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.ValueSources;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String LOTTO_ERROR_MESSAGE = "로또 번호는 1부터 45 사이의 다른 숫자 6개여야 합니다.";
    private static final String DISTINCT_ERROR = "중복된 숫자가 없어야 합니다.";
    private static final String LOTTO_NUMBER_ERROR = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String CONTAINS_LOTTO_NUMBER = "당첨 번호가 포함되어있지 않은 번호를 입력해 주세요.";
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
    void 중복된_당첨_번호_입력() {
        assertSimpleTest(() -> {
            runException("1000", "1,1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE + " " + DISTINCT_ERROR);
        });
    }

    @Test
    void 당첨_번호_입력시_번호_외_입력() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE + " " + LOTTO_ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,3,4,5,6,7", "1000:1,2,3,4,5"}, delimiter = ':')
    void 개수_미만_또는_초과인_경우(String inputMoney, String inputLottos) {
        assertSimpleTest(() -> {
            runException(inputMoney, inputLottos);
            assertThat(output()).contains(ERROR_MESSAGE + " " + LOTTO_ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", "46", "-1"})
    void 보너스_번호_오류_입력인_경우(String bonus) {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", bonus);
            assertThat(output()).contains(ERROR_MESSAGE + " " + LOTTO_NUMBER_ERROR);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void 보너스_번호가_당첨번호_안에_존재하는_값인_경우(String bonus) {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", bonus);
            assertThat(output()).contains(ERROR_MESSAGE + " " + CONTAINS_LOTTO_NUMBER);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
