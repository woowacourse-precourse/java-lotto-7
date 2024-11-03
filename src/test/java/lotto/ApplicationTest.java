package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 정상입력_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.setBonusNum(7);

        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getBonusNum()).isEqualTo(7);

        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(
                    "구입금액을 입력해주세요.",
                    "8개를 구매했습니다.",
                    "보너스 번호를 입력해 주세요."
            );
        });
    }

    @Test
    void 구매금액_예외_테스트_1() {
        assertSimpleTest(()->{
            runException("팔천원");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 유효한 숫자를 입력하세요."
            );
        });
    }

    @Test
    void 구매금액_예외_테스트_2() {
        assertSimpleTest(()->{
            runException("8001");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 1,000원 단위로 입력하세요"
            );
        });
    }

    @Test
    void 당첨번호_예외_테스트_1() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,six");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 유효한 숫자를 입력하세요."
            );
        });
    }

    @Test
    void 당첨번호_예외_테스트_2() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 로또 번호는 6개여야 합니다."
            );
        });
    }

    @Test
    void 당첨번호_예외_테스트_3() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,4,5");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 중복되지 않는 번호를 입력하세요."
            );
        });
    }

    @Test
    void 당첨번호_예외_테스트_4() {
        assertSimpleTest(() -> {
            run("8000", "0,1,2,3,4,5");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 1부터 45 사이의 숫자를 입력하세요."
            );
        });
    }

    @Test
    void 보너스번호_중복입력_예외_테스트_1() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 1부터 45 사이의 숫자를 입력하세요."
            );
        });
    }

    @Test
    void 보너스번호_중복입력_예외_테스트_2() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 당첨번호와 중복되지 않는 번호를 입력하세요."
            );
        });
    }


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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
