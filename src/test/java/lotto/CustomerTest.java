package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    void 소비자테스트() {
        int result = 10;
        Customer customer= new Customer("10000");
        assertEquals(result,customer.lottoCount);
    }
}
