package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Application.validateAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
    }

    @Test
    void 올바른_금액을_입력했을_때_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> Application.validateAmount(3000));
    }
    @Test
    void 문자열을_정수로_변환할_때_숫자가_아닌_값을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> Application.convertToInteger("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해야 합니다.");
    }

    @Test
    void 중복된_로또_번호가_있는_경우_예외가_발생한다() {
        Integer[] duplicateNumbers = {1, 2, 3, 4, 5, 5};
        assertThatThrownBy(() -> Application.validateLottoNumbers(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 번호가 있습니다.");
    }

    @Test
    void 로또_번호가_6개가_아닐_경우_예외가_발생한다() {
        String[] input = {"1", "2", "3", "4", "5"};
        assertThatThrownBy(() -> Application.validateStringLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호 6개를 입력해야 합니다.");
    }

    @Test
    void 유효_범위_밖의_로또_번호가_있는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Application.validateLottoNumber(50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 랜덤_로또_번호_생성_시_6개의_정렬된_숫자가_생성된다() {
        List<Integer> randomNumbers = Application.generateRandomNumbers();
        assertThat(randomNumbers).hasSize(6);
        assertThat(randomNumbers).isSorted();
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
