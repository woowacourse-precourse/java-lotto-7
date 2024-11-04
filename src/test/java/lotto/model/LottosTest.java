package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("로또 구매 횟수와 로또의 개수가 일치하지 않으면 예외가 발생한다.")
    void validateLottoNumber() {
        List<List<Integer>> numbers = new ArrayList<>();
        numbers.add(List.of(1, 2, 3, 4, 5, 6));
        int numberOfLottos = 2;
        assertThrows(IllegalArgumentException.class, () -> {
            Lottos lottos = Lottos.getInstance(numbers, numberOfLottos);
        });
    }

    @Test
    @DisplayName("입력한 값이 잘 반환되는지 확인한다.")
    void getLottos() {
        List<List<Integer>> numbers = new ArrayList<>();
        List<Integer> addList= new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        numbers.add(addList);
        int numberOfLottos = 1;
        Lottos lottos = Lottos.getInstance(numbers, numberOfLottos);
        assertEquals(addList, lottos.getLottos().get(0).getNumbers());
    }

    @Test
    @DisplayName("Lottos 객체를 생성한다.")
    void getInstance() {
        List<List<Integer>> numbers = new ArrayList<>();
        numbers.add(List.of(1, 2, 3, 4, 5, 6));
        int numberOfLottos = 1;
        Lottos lottos = Lottos.getInstance(numbers, numberOfLottos);
        assertNotNull(lottos);
    }
}