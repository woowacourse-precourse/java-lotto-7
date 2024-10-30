package view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import model.LottoAmount;
import org.junit.jupiter.api.Test;

public class OutputViewTest extends NsTest {

    @Test
    void 구매_로또_갯수_출력_테스트(){
        OutputView outputView = new OutputView();
        LottoAmount lottoAmount = new LottoAmount(8234);

        outputView.printLottoAmount(lottoAmount);
        String outputString = output();

        assertThat(outputString).isEqualTo("8개를 구매했습니다.");
    }
    @Override
    protected void runMain() {

    }
}
