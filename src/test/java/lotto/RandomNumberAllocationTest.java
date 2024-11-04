package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberAllocationTest {

    private  RandomNumAllocation instance;

    @Test
    void RandomNumAllocationTet1() {

        instance=new RandomNumAllocation(5000);
        assertEquals(5,instance.getPurchasedLottos().size());
    }
}
