package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AttemptTest {
    @Test
    void 금액에_따른_구매_가능한_갯수를_반환한다() {
        int input = 2000;
        int expected = 2;

        Attempt attempt = new Attempt(input);

        Assertions.assertEquals(expected, attempt.getLottoAmount());
    }
}
