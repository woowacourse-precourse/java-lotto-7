package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void makeNumbers(){
        //given
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1,45,6);

    }

}