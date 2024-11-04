package lotto.service.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyLottoTest {

    List<Integer> correctNumbers;
    List<Integer> inCorrectNumbers;

    @BeforeEach
    public void 셋업() {
        correctNumbers = Arrays.asList(1,2,3,4,5,6);
        inCorrectNumbers = Arrays.asList(1,2,3,4,5);
    }

    @Test
    public void 유효한_로또_생성() {
        Lotto lotto = new Lotto(correctNumbers);

        assertEquals(6, lotto.getLottoticket().size());
    }

    @Test
    public void 유효하지_않은_로또_생성() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(inCorrectNumbers);
        });

        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());

//        assertThrows(IllegalArgumentException.class, () -> {
//            new Lotto(inCorrectNumbers);
//        }, "[ERROR] 로또 번호는 6개여야 합니다.");
    }
}