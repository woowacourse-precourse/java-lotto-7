package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.exception.EmptyInputException;
import lotto.exception.NotNumberException;
import lotto.exception.administrator.LottoNumbersDuplicationException;
import lotto.exception.administrator.LottoNumbersMustBeSixException;
import lotto.exception.administrator.NotNumberOrCommaException;
import lotto.exception.administrator.OutOfRangeLottoNumberException;
import lotto.exception.user.LottoMaximumExceededException;
import lotto.exception.user.NotEnoughMoneyException;
import lotto.exception.user.NotThousandUnitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DrawGamesTest extends NsTest {

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

    @Nested
    @DisplayName("금액 입력시 예외 테스트")
    class MoneyInsertExceptionTests {

        @Test
        void 금액입력시_빈값_예외테스트() {
            assertSimpleTest(() -> {
                runException("\n");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(new EmptyInputException().getMessage());
            });
        }

        @Test
        void 금액입력시_숫자외_문자_예외테스트() {
            assertSimpleTest(() -> {
                runException("1000j");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(new NotNumberException().getMessage());
            });
        }

        @Test
        void 금액입력시_최대구매수량초과_예외테스트() {
            assertSimpleTest(() -> {
                runException("101000");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(new LottoMaximumExceededException().getMessage());
            });
        }

        @Test
        void 금액입력시_금액부족_예외테스트() {
            assertSimpleTest(() -> {
                runException("500");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(new NotEnoughMoneyException().getMessage());
            });
        }

        @Test
        void 금액입력시_금액단위_예외테스트() {
            assertSimpleTest(() -> {
                runException("1500");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(new NotThousandUnitException().getMessage());
            });
        }
    }

    @Nested
    @DisplayName("당첨번호 입력시 예외 테스트")
    class LottoNumberInputExceptionTests {

        @Test
        void 당첨번호_입력시_숫자및콤마외_문자_예외테스트() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,;6");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(new NotNumberOrCommaException().getMessage());
            });
        }

        @Test
        void 당첨번호_입력시_범위_예외테스트() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,46,6");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(new OutOfRangeLottoNumberException().getMessage());
            });
        }

        @Test
        void 당첨번호_입력시_숫자6개_아닌경우_예외테스트() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6,7");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(new LottoNumbersMustBeSixException().getMessage());
            });
        }

        @Test
        void 당첨번호_입력시_중복_예외테스트() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,5");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(new LottoNumbersDuplicationException().getMessage());
            });
        }
    }


    @Override
    public void runMain() {
            Application.main(new String[]{});
        }

}