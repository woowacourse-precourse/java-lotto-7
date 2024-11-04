package lotto.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

public class OutputViewTest extends NsTest {

    @Test
    void 로또_구매_내역_출력_테스트() {
        runWithCustomOutput(() -> {
            List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
            );
            OutputView.printPurchases(lottos.size(), lottos);
        });

        String expectedOutput = "2개를 구매했습니다.\n"
                + "[1, 2, 3, 4, 5, 6]\n"
                + "[7, 8, 9, 10, 11, 12]";

        assertThat(output()).contains(expectedOutput);
    }

    private void runWithCustomOutput(Runnable customMethod) {
        try {
            customMethod.run();
        } finally {
            Console.close(); // 필요시 Console 관련 자원 해제
        }
    }

    @Override
    public void runMain() {

    }

}
