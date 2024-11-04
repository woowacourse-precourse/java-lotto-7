package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("정상적인 로또 번호가 입력되었을 때 로또 객체가 생성된다.")
    @Test
    void 정상_로또_생성_테스트() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertEquals(validNumbers, lotto.getNumbers());
    }


}
