package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.Test;

class UserLottoListTest {

    @Test
    void 입력한_개수만큼_로또_발행() throws NoSuchFieldException, IllegalAccessException {
        UserLottoList userLottoList = new UserLottoList(5);

        Field lottoListField = userLottoList.getClass().getDeclaredField("lottoList");
        lottoListField.setAccessible(true);
        List<Lotto> lottoList = (List<Lotto>) lottoListField.get(userLottoList);

        assertEquals(5, lottoList.size());
    }
}