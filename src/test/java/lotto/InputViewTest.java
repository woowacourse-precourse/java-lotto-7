package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {

    @Test
    @DisplayName("구입금액이 1000원 단위가 아닌경우")
    public void Not1000PerBuyAmount(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1200"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOTPER1000BUYAMOUNT.getMessage())
        );
    }

    @Test
    @DisplayName("구입금액이 정수가 아닌경우")
    public void NotNumberBuyAmount(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("k"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOTNUMBERBUYAMOUNT.getMessage())
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOTNUMBERBUYAMOUNT.getMessage())
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
