package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "45");
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

    @ParameterizedTest
    @ValueSource(strings = {"-", "bug", "infinite", "2024y", "get()"})
    void 구입금액이_숫자가_아니면_예외가_발생한다(String invalidPurchaseAmount) {
        /// given
        // when
        // then
        assertSimpleTest(() -> {
            runException(invalidPurchaseAmount);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액이_공백으로_이루어져_있으면_예외가_발생한다() {
        /// given
        // when
        // then
        assertSimpleTest(() -> {
            runException("    ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액이_NULL_이면_예외가_발생한다() {
        /// given
        String invalidAmount = null;
        // when
        // then
        assertSimpleTest(() -> {
            runException(invalidAmount);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-1000", "-999"})
    void 음수_혹은_0이하일때_입력_예외가_발생한다(String invalidPurchaseAmount) {
        /// given
        // when
        // then
        assertSimpleTest(() -> {
            runException(invalidPurchaseAmount);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "999", "1001", "2001", "9999"})
    void 로또_구매_금액_단위로_나누어지지_않으면_입력_예외가_발생한다(String invalidPurchaseAmount) {
        /// given
        // when
        // then
        assertSimpleTest(() -> {
            runException(invalidPurchaseAmount);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @MethodSource("provideWinningNumbersNotInNumericFormat")
    void 당첨번호를_입력할떄_숫자가_아닌형식이면_예외가_발생한다(String invalidWinningNumbers) {
        /// given
        // when
        // then
        assertSimpleTest(() -> {
            runException("3000", invalidWinningNumbers);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @MethodSource("provideConsistingOfInvalidWiningNumbers")
    void 당첨번호를_입력할떄_1과45이하_숫자가_아니면_예외가_발생한다(String invalidWinningNumbers) {
        /// given
        // when
        // then
        assertSimpleTest(() -> {
            runException("3000", invalidWinningNumbers);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateWinningNumber")
    void 당첨번호를_입력할떄_중복된_숫자가_있으면_예외가_발생한다(String invalidWinningNumbers) {
        /// given
        // when
        // then
        assertSimpleTest(() -> {
            runException("3000", invalidWinningNumbers);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @MethodSource("ProvideNotConsistingOf6Numbers")
    void 당첨번호를_입력할떄_6개_숫자로_구성되지_않으면_예외가_발생한다(String invalidWinningNumbers) {
        /// given
        // when
        // then
        assertSimpleTest(() -> {
            runException("3000", invalidWinningNumbers);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    private static Stream<Arguments> provideWinningNumbersNotInNumericFormat() {
        return Stream.of(
                Arguments.of(" "),
                Arguments.of("-,2,3,4,5,6"),
                Arguments.of("1,-,3,4,5"),
                Arguments.of(", , , , ,"),
                Arguments.of("-,-,-,-,-,-")
        );
    }

    private static Stream<Arguments> provideConsistingOfInvalidWiningNumbers() {
        return Stream.of(
                Arguments.of("100,1,2,3,4,5"),
                Arguments.of("1,2,3,4,5,46"),
                Arguments.of("-1,2,3,4,5,6"),
                Arguments.of("0,1,2,3,4,5")
        );
    }

    private static Stream<Arguments> provideDuplicateWinningNumber() {
        return Stream.of(
                Arguments.of("1,1,2,3,4,5"),
                Arguments.of("1,2,3,4,5,5"),
                Arguments.of("1,2,3,4,5,1"),
                Arguments.of("1,2,3,4,3,5")
        );
    }

    @ParameterizedTest
    @MethodSource("providesDuplicateBonusNumbers")
    void 당첨번호와_보너스번호가_중복되면_예외가_발생한다(String winningNumbers, String duplicateWinningNumber) {
        /// given
        // when
        // then
        assertSimpleTest(() -> {
            runException("3000", winningNumbers, duplicateWinningNumber);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    private static Stream<Arguments> ProvideNotConsistingOf6Numbers() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6,7"),
                Arguments.of("1,2,3,4,5"),
                Arguments.of("1,2,3")
        );
    }

    private static Stream<Arguments> providesDuplicateBonusNumbers() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", "1"),
                Arguments.of("1,2,3,4,5,6", "2"),
                Arguments.of("1,2,3,4,5,6", "3"),
                Arguments.of("1,2,3,4,5,6", "4"),
                Arguments.of("1,2,3,4,5,6", "5"),
                Arguments.of("1,2,3,4,5,6", "6")
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
