package lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    public void 구매_테스트(){
        String input = "3000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int amount = Input.purchase();
        assertEquals(amount,3000);
    }

    @Test
    public void 구매_예외_테스트(){
        String input = "3000,";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class,()->{
            int amount = Input.purchase();
        });
    }

    @Test
    public void 로또번호_테스트() {
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Integer> integers = Input.inputNumber();
        assertEquals(integers.size(),6);
    }

    @Test
    public void 로또번호_예외_테스트(){
        String input = "1,2.3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class , ()->{
            Input.inputNumber();
        });
    }


}