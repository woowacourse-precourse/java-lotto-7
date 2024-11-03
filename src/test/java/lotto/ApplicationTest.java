package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

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

    @DisplayName("금액이 빈 칸이면 예외가 발생한다.")
    @Test
    void EMPTY_INPUT_ERROR() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AmountValidator validator = new AmountValidator();
            validator.validateInput("");
        });
        String expectedMessage = "[ERROR] 구매 금액을 입력해주세요.";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).contains(expectedMessage);
    }

    @DisplayName("금액이 공백이면 예외가 발생한다.")
    @Test
    void SPACE_INPUT_ERROR() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("문자로 입력하면 예외가 발생한다.")
    @Test
    void STRING_ERROR() {
        assertSimpleTest(() -> {
            runException("천 원");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("쉼표를 제외한 특수기호로 입력하면 예외가 발생한다.")
    @Test
    void MARKS_ERROR() {
        assertSimpleTest(() -> {
            runException("1[]000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("천 단위 이외에 쉼표가 붙으면 예외가 발생한다.")
    @Test
    void COMMA_FORMAT_ERROR1() {
        assertSimpleTest(() -> {
            runException("100,0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("천 단위 이외에 쉼표가 붙으면 예외가 발생한다.")
    @Test
    void COMMA_FORMAT_ERROR2() {
        assertSimpleTest(() -> {
            runException("1,0,000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("최소 금액(1000원) 불만족 시 예외가 발생한다.")
    @Test
    void MINIMUM_AMOUNT_ERROR() {
        assertSimpleTest(() -> {
            runException("900");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void AMOUNT_UNIT_ERROR() {
        assertSimpleTest(() -> {
            runException("5404");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("음수인 경우에 예외가 발생한다.")
    @Test
    void NEGATIVE_AMOUNT_ERROR() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
