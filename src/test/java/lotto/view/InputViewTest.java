package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private static InputView inputView;

    @BeforeAll
    static void init(){
        inputView = new InputView();
    }

    @AfterEach
    void reset(){
        Console.close();
        System.setIn(System.in);
    }

    @Test
    void 입력한_금액_값이_0보다_작은지_확인한다(){
        String input = "-1000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class,
                inputView::getAmount);
    }

    @Test
    void 입력한_금액_값이_숫자가_아닌_값이_있는지_확인한다(){
        String input = "1000a";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class,
                inputView::getAmount);
    }

    @Test
    void 입력값이_비어있는지_확인한다(){
        String input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class,
                inputView::getAmount);
    }

}