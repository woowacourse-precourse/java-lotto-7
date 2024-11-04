package lotto.console;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleManagerTest {
    @Test
    void 입력한_숫자가_비어있는지_확인한다(){
        assertThrows(IllegalArgumentException.class,
                ()->ConsoleManager.toNumeric(""));
    }

    @Test
    void 입력한_숫자가_아닌_다른_문자가_있는지_확인한다(){
        assertThrows(IllegalArgumentException.class,
                ()->ConsoleManager.toNumeric("100f0"));
    }


    @Test
    void 입력한_당첨번호에_다른_문자가_있는지_확인한다(){
        assertThrows(IllegalArgumentException.class,
                ()->ConsoleManager.toNumberList("1,5,3ff6,2,6"));
    }


    @Test
    void 입력한_당첨번호가_비어있는지_확인한다(){
        assertThrows(IllegalArgumentException.class,
                ()->ConsoleManager.toNumberList(""));
    }
}