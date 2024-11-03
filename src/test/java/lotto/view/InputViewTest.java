package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private InputView view;

    @BeforeEach
    void reset(){
        view = new InputView();
        System.setIn(System.in);
        Console.close();
    }

    @Test
    void 구임금액_이외의_문자가_있는지_확인한다(){
        String input = "1000f";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, view::getAmount);
    }

    @Test
    void 당첨번호_이외의_문자가_있는지_확인한다(){
        String input = "35,15,2,6,1f,5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, view::getWinning);
    }

    @Test
    void 보너스_번호_이외의_문자가_있는지_확인한다(){
        String input = "35f";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, view::getAmount);
    }

}