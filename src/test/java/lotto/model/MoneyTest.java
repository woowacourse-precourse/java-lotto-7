package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void 입력된돈에숫자가아닌값이들어갔을경우() {
        // given
        // when
        // then
        assertThrows(IllegalArgumentException.class,()->new Money("8000j"));

    }

}