package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.core.Lotto;
import lotto.core.LottoRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRunnerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    @Test
    @DisplayName("기능 테스트 :: 구매 금액에 따른 구매 장 수 구하기")
    void getPurchaseAmountTest() {
        assertSimpleTest(() -> {
            run("14000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains("14개를 구매했습니다.");
        });
    }

    @Test
    @DisplayName("기능 테스트 :: 구매 수량만큼 무작위 로또 생성")
    void selectionTest() {
        int expectedAmount = 14;

        List<Lotto> generatedLottos = new LottoRunner().selection(expectedAmount);

        assertThat(generatedLottos).isNotNull();    // null 체크
        assertThat(generatedLottos.size()).isEqualTo(expectedAmount);   // 사이즈 체크

        // 각 로또 객체가 6개의 숫자를 포함하는지 확인
        for (Lotto lotto : generatedLottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }

    @Test
    @DisplayName("기능 테스트 :: 등수별 당첨 결과 출력")
    void statsByRankTest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("6000", "11,12,13,14,15,16", "17");
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 2개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 0개"
                );
            },
            List.of(3, 11, 15, 16, 32, 38),
            List.of(12, 14, 16, 17, 36, 44),
            List.of(11, 13, 14, 16, 42, 45),
            List.of(11, 12, 14, 15, 16, 17),
            List.of(2, 13, 22, 32, 38, 45),
            List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    @DisplayName("기능 테스트 :: 수익률 계산 및 출력")
    void rateOfReturnTest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("9000", "11,12,13,14,15,16", "17");
                assertThat(output()).contains(
                    "총 수익률은 55.6%입니다."
                );
            },
            List.of(3, 11, 16, 18, 32, 38),
            List.of(1, 6, 18, 34, 42, 45),
            List.of(3, 8, 29, 30, 43, 44),
            List.of(12, 14, 16, 17, 36, 44),
            List.of(2, 13, 22, 32, 38, 45),
            List.of(14, 17, 23, 24, 38, 41),
            List.of(10, 32, 37, 38, 41, 44),
            List.of(11, 27, 31, 39, 40, 43),
            List.of(13, 15, 25, 26, 34, 39)
        );

    }

    @Test
    @DisplayName("예외 테스트 :: 구입 금액이 빈값일 경우 예외 발생")
    void throwExceptionIfPaymentIsEmpty() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE + "숫자를 입력해주세요.");
        });
    }

    @Test
    @DisplayName("예외 테스트 :: 구입 금액이 숫자가 아닐 경우 예외 발생")
    void throwExceptionIfPaymentIsNotInteger() {
        assertSimpleTest(() -> {
            runException("string123");
            assertThat(output()).contains(ERROR_MESSAGE + "숫자를 입력해주세요.");
        });
    }

    @Test
    @DisplayName("예외 테스트 :: 구입 금액이 1,000 단위가 아닐 경우 예외 발생")
    void throwExceptionIfMinimumUnitNotMatched() {
        assertSimpleTest(() -> {
            runException("3200");
            assertThat(output()).contains(ERROR_MESSAGE + "구매 금액은 1,000원 단위로 입력해야 합니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
