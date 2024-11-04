package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class PocketTest {
    @Test
    public void 주머니에_돈과_로또_여러개_집어넣기_테스트() throws Exception {
        //given
        int money = 2000;
        List<Integer> inputLotto1 = new ArrayList<>(List.of(1,2,3,4,5,6));
        List<Integer> inputLotto2 = new ArrayList<>(List.of(2,3,4,5,6,7));

        //when
        Lotto lotto1 = new Lotto(inputLotto1);
        Lotto lotto2 = new Lotto(inputLotto2);
        Pocket pocket = new Pocket(List.of(lotto1,lotto2),money);

        //then
        assertEquals(pocket.getMoney(),money);
        assertEquals(pocket.getLottos().size(),2);
    }
}