package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    InputView inputView=new InputView();


    @AfterEach
    void closeConsole(){
        Console.close();
    }
    @Test
    void 구입금액_입력(){
        String simulatedInput = "4000";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        int actual=inputView.readMoney();
        assertThat(actual).isEqualTo(4000);
    }
    @Test
    void 구입금액_입력_에러_숫자가_아닌값(){
        String simulatedInput = "4000j";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));


        assertThatThrownBy(() -> inputView.readMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 구입금액_입력_에러_공백(){
        String simulatedInput = " ";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));


        assertThatThrownBy(() -> inputView.readMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_입력(){
        String simulatedInput = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        List<Integer> actual=inputView.readWiningNumbers();
        assertThat(actual).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    void 보너스번호_입력(){
        String simulatedInput = "7";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        int actual=inputView.readBonusNumbers();
        assertThat(actual).isEqualTo(7);
    }

    @Test
    void 보너스번호_입력_에러_숫자가_아닌값(){
        String simulatedInput = "jk";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThatThrownBy(() -> inputView.readBonusNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
