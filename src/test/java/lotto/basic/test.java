package lotto.basic;

import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class test {

    @Test
    void 금액_입력_테스트() {
        // given
        InputView inputView =  new InputView();
        String expectInput = "12000";

        // when
        System.setIn(new ByteArrayInputStream(expectInput.getBytes()));
        String actualInput = inputView.getMoney();

        // then
        assertThat(actualInput).isEqualTo(expectInput);
    }
}
