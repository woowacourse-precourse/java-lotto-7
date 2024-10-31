package lotto.basic;

import lotto.domain.Money;
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
        Money expectInput = new Money("14000");

        // when
        System.setIn(new ByteArrayInputStream(String.valueOf(expectInput.getMoney())
                .getBytes()));
        Money actualInput = inputView.getMoney();

        // then
        assertThat(actualInput.getMoney()).isEqualTo(expectInput.getMoney());
    }
}
