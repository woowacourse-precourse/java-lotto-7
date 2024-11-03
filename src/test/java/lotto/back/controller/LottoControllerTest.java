package lotto.back.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static lotto.global.enums.ExceptionMessage.*;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {
    private final LottoController lottoController = new LottoController();

    @Test
    @DisplayName("1등을 5번 했을 때, 수익률 계산이 잘 수행되는지 확인")
    void 통합_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "10,12,32,43,44,45", "20");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[10, 12, 32, 43, 44, 45]",
                            "[10, 12, 32, 43, 44, 45]",
                            "[10, 12, 32, 43, 44, 45]",
                            "[10, 12, 32, 43, 44, 45]",
                            "[10, 12, 32, 43, 44, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 5개",
                            "총 수익률은 200000000.0%입니다."
                    );
                },
                List.of(10, 12, 32, 43, 44, 45),
                List.of(10, 12, 32, 43, 44, 45),
                List.of(10, 12, 32, 43, 44, 45),
                List.of(10, 12, 32, 43, 44, 45),
                List.of(10, 12, 32, 43, 44, 45)
        );
    }

    @Test
    @DisplayName("2개의 로또 번호에 대해 2등과 3등을 잘 고르는지 확인")
    void 기능_테스트2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "10,12,32,42,43,5", "44");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[10, 12, 32, 42, 43, 45]",
                            "[10, 12, 32, 42, 43, 44]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1575000.0%입니다."
                    );
                },
                List.of(10, 12, 32, 42, 43, 45),
                List.of(10, 12, 32, 42, 43, 44)
        );
    }

    @Test
    @DisplayName("숫자가 아닌 가격이 들어 왔을 때 에러 메시지 출력")
    void 예외_통합_테스트1() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(INVALID_LOTTO_PRICE.getMessage());
        });
    }

    @Test
    @DisplayName("가격이 1,000원 단위가 아닐 때 에러 메시지 출력")
    void 예외_통합_테스트2() {
        assertSimpleTest(() -> {
            runException("100");
            assertThat(output()).contains(INVALID_LOTTO_PRICE_UNIT.getMessage());
        });
    }

    @Test
    @DisplayName("로또 번호가 포맷에 맞지 않거나 숫자가 아닌 문자가 들어왔을 때 에러 메시지 출력")
    void 예외_통합_테스트3() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,");
            assertThat(output()).contains(INVALID_LOTTO_NUMBER_FORMAT.getMessage());
        });
    }

    @Test
    @DisplayName("로또 번호가 6자리가 아닐 때 에러 메시지 출력")
    void 예외_통합_테스트4() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        });
    }

    @Test
    @DisplayName("로또 번호가 중복될 때 에러 메시지 출력")
    void 예외_통합_테스트5() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains(DUPLICATED_LOTTO_NUMBER.getMessage());
        });
    }

    @Test
    @DisplayName("로또 번호가 1과 45 사이가 아닐 때 에러 메시지 출력")
    void 예외_통합_테스트6() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,55");
            assertThat(output()).contains(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        });
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닐 때 에러 메시지 출력")
    void 예외_통합_테스트7() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "asd");
            assertThat(output()).contains(INVALID_BONUS_NUMBER.getMessage());
        });
    }

    @Test
    @DisplayName("보너스 번호와 추첨 번호가 중복될 때 에러 메시지 출력")
    void 예외_통합_테스트8() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(DUPLICATED_LOTTO_NUMBER.getMessage());
        });
    }

    @Override
    protected void runMain() {
        lottoController.run();
    }
}