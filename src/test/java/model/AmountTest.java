package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

public class AmountTest {
    @Test
    void amount_생성확인(){
        Amount amount1 = new Amount(new BigInteger("8000"));

        BigInteger value = amount1.getPurchaseAmount();

        assertThat(value.compareTo(new BigInteger("8000"))).isEqualTo(0);
    }
}
