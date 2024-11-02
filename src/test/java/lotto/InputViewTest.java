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

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOTNUMBERBUYAMOUNT.getMessage())
        );
    }

    @Test
    @DisplayName("입력된 당첨번호의 구분자가 , 가 아닌경우")
    public void NotDelimiterWinnumber(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000", "1|2|3|4|5|6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOTDELIMITERWINNUMBERS.getMessage())
        );
    }

    @Test
    @DisplayName("입력된 당첨번호가 숫자가 아닌경우")
    public void NotNumberWinnumber(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000", "1,2,3,4,a,6","1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOTNUMBERWINNUMBERS.getMessage())
        );
    }

    @Test
    @DisplayName("입력된 보너스번호가 정수가 아닌경우")
    public void NotNumberBonusnumber(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,6","a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOTNUMBERBONUSNUMBER.getMessage())
        );
    }

    @Test
    @DisplayName("입력된 보너스번호가 범위를 벗어나는경우")
    public void OutofRangeBonusNumber(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,6","46"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.OUTOFRANGEBONUSNUMBER.getMessage())
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
