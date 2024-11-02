package lotto.service;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class LottoServiceTest {

    LottoService service = new LottoService();

    @RepeatedTest(100)
    void 로또_번호_생성() {
        List<Integer> numbers = service.getLottoNumbers();

        long expected = numbers.stream().distinct().count();

        Assertions.assertEquals(numbers.size(), expected);
    }
}
