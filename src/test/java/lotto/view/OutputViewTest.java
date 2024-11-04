package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.data.Lotto;
import lotto.data.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NsTest {

    private OutputView outputView = new OutputView();

    @DisplayName("구매한 로또를 출력한다.")
    @Test
    void printPurchaseLottoTest() {
        // given
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        // when
        outputView.printPurchaseLotto(lottoList);
        // then
        assertThat(output()).contains(
                "2개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]"
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
