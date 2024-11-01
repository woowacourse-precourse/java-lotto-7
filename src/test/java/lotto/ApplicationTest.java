package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("통합 테스트")
class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("로또를 구매하고 수익률을 확인할 수 있다.")
    void 로또를_구매하고_수익률을_확인할_수_있다() {
        // Given
        String purchaseAmount = "8000";
        String winningNumber = "1,2,3,4,5,6";
        String bonusNumber = "7";

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    // When
                    run(purchaseAmount, winningNumber, bonusNumber);
                    String result = output();

                    // Then
                    assertThat(result).contains(
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
    @DisplayName("수익률은 소수점 둘째 자리에서 반올림한다.")
    void 수익률은_소수점_둘째_자리에서_반올림한다() {
        // Given
        String purchaseAmount = "7000";
        String winningNumber = "1,2,3,4,5,6";
        String bonusNumber = "7";

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    // When
                    run(purchaseAmount, winningNumber, bonusNumber);
                    String result = output();

                    // Then
                    assertThat(result).contains(
                            "7개를 구매했습니다.",
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
                            "총 수익률은 71.4%입니다."
                    );
                },
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
    @DisplayName("구입 가격을 잘못 입력하면 예외가 발생한다.")
    void 구입_가격을_잘못_입력하면_예외가_발생한다() {
        assertSimpleTest(() -> {
            // Given
            String purchaseAmount = "1000j";
            String winningNumber = "1,2,3,4,5,6";
            String bonusNumber = "7";

            // When
            runException(purchaseAmount, winningNumber, bonusNumber);
            String result = output();

            // Then
            assertThat(result).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구입 가격이 1,000의 배수가 아니면 예외가 발생한다.")
    void 구입_가격이_1000의_배수가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            // Given
            String purchaseAmount = "1001";
            String winningNumber = "1,2,3,4,5,6";
            String bonusNumber = "7";

            // When
            runException(purchaseAmount, winningNumber, bonusNumber);
            String result = output();

            // Then
            assertThat(result).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호가 잘못 입력되면 예외가 발생한다.")
    void 당첨_번호가_잘못_입력되면_예외가_발생한다() {
        assertSimpleTest(() -> {
            // Given
            String purchaseAmount = "1000";
            String winningNumber = "1, 2, 3, 4, 5, 6";
            String bonusNumber = "7";

            // When
            runException(purchaseAmount, winningNumber, bonusNumber);
            String result = output();

            // Then
            assertThat(result).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호가 0보다 작으면 예외가 발생한다.")
    void 당첨_번호가_0보다_작으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            // Given
            String purchaseAmount = "1000";
            String winningNumber = "0,2,3,4,5,6";
            String bonusNumber = "7";

            // When
            runException(purchaseAmount, winningNumber, bonusNumber);
            String result = output();

            // Then
            assertThat(result).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호가 45보다 크면 예외가 발생한다.")
    void 당첨_번호가_45보다_크면_예외가_발생한다() {
        assertSimpleTest(() -> {
            // Given
            String purchaseAmount = "1000";
            String winningNumber = "1,2,3,4,5,46";
            String bonusNumber = "7";

            // When
            runException(purchaseAmount, winningNumber, bonusNumber);
            String result = output();

            // Then
            assertThat(result).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호가 0보다 작으면 예외가 발생한다.")
    void 보너스_번호가_0보다_작으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            // Given
            String purchaseAmount = "1000";
            String winningNumber = "1,2,3,4,5,6";
            String bonusNumber = "0";

            // When
            runException(purchaseAmount, winningNumber, bonusNumber);
            String result = output();

            // Then
            assertThat(result).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    void 보너스_번호가_45보다_크면_예외가_발생한다() {
        assertSimpleTest(() -> {
            // Given
            String purchaseAmount = "1000";
            String winningNumber = "1,2,3,4,5,6";
            String bonusNumber = "46";

            // When
            runException(purchaseAmount, winningNumber, bonusNumber);
            String result = output();

            // Then
            assertThat(result).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
