package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void 로또_번호는_음수가_될수없다(){
        assertThrows(IllegalArgumentException.class, () -> new Number(-1));
    }

    @Test
    void 로또_번호는_45를_넘길_수_없다(){
        assertThrows(IllegalArgumentException.class, () -> new Number(47));
    }

}