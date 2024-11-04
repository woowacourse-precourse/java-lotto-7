package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import object.Lotto;
import object.RandomLottos;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    int lottoQuantity = 5;

    RandomLottos randomLottos = new RandomLottos(lottoService.makeRandomLottos(lottoQuantity));


    @Test
    void testMakeRandomLottos_sizeTest() {
        assertEquals(lottoQuantity, randomLottos.getLottos().size(), "랜덤 로또 생성 검사");
    }

    @Test
    void testMakeRandomLottos_randomNumbers() {
        for (Lotto lotto : randomLottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();

            for (int number : numbers) {
                assertTrue(number >= 1 && number <= 45, "로또 숫자 범위 검사");
            }
        }
    }

    @Test
    void testMakeRandomLottos_lottoSize() {
        for (Lotto lotto : randomLottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();

            assertEquals(6, numbers.size(), "로또 6자리 검사");
            assertEquals(6, numbers.stream().distinct().count(), "중복 검사");
        }
    }
}
