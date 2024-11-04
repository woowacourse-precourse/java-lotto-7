package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    void 필요한_장_수_만큼_로또를_만든다() {
        int quantity = 3;
        List<Lotto>  result = LottoGenerator.generate(quantity);

        assertEquals(3, result.size());
    }

}
