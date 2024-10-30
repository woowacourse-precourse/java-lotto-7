package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class UserLottoNumberTest {

    @Test
    void 입력된_로또_번호_정렬_테스트() {
        String input = "5,11,2,7,1,34";

        UserLottoNumber userLottoNumber = new UserLottoNumber(input);
        List<Integer> result = userLottoNumber.get();

        assertEquals(List.of(1, 2, 5, 7, 11, 34), result);
    }
}