package lotto.viewHandler.validator;

import lotto.viewHandler.exception.NotInteger;
import lotto.viewHandler.validator.validatorImpl.ParseInt;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParseIntTest {
    private final ParseInt validator;

    public ParseIntTest() {
        this.validator = new ParseInt();
    }

    @Test
    void 정상_작동_확인() {
        String input = "10000";
        Integer expect = 10_000;
        Integer result = validator.validate(input);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 검증_확인() {
        String input = "10_000r";
        assertThatThrownBy(() -> {
            validator.validate(input);
        }).isInstanceOf(NotInteger.class);
    }
}