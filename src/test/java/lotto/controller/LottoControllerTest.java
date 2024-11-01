package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {

    @Test
    @DisplayName("발행한 로또 수량 및 번호를 출력한다")
    void purchase_with_sorted() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    run("8000");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]"
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
    @DisplayName("발행한 로또 수량 및 번호를 출력하며 로또 번호는 오름차순으로 정렬해서 보여준다")
    void purchase_with_unsorted() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    run("1000");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]"
                    );
                },
                List.of(21, 8, 43, 42, 23, 41)
        );
    }

    @Override
    protected void runMain() {
        new LottoController().purchase();
    }
}
