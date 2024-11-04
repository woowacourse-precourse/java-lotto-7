package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    @Test
    @DisplayName("Prints lotto tickets correctly")
    void printLottoTickets_Test() {
        assertSimpleTest(() -> {
            List<Lotto> tickets = List.of(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(7, 8, 9, 10, 11, 12))
            );
            OutputView.printLottoTickets(tickets);
            assertThat(output()).contains(
                    "[1, 2, 3, 4, 5, 6]",
                    "[7, 8, 9, 10, 11, 12]"
            );
        });
    }

    @Test
    @DisplayName("Prints profit rate correctly")
    void printProfitRate_Test() {
        assertSimpleTest(() -> {
            OutputView.printProfitRate(123.456);
            assertThat(output()).contains("총 수익률은 123.5%입니다.");
        });
    }

    @Test
    @DisplayName("Prints error messages correctly")
    void printError_Test() {
        assertSimpleTest(() -> {
            OutputView.printError("[ERROR] 테스트 에러");
            assertThat(output()).contains("[ERROR] 테스트 에러");
        });
    }

    @Override
    public void runMain() {
    }
}
