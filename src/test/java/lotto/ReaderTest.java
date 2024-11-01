package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ReaderTest extends NsTest {

    private Reader reader = new Reader();

    @Test
    void readMoney() {
        assertSimpleTest(() -> {
            run("8000");
            assertThat(reader.readMoney()).isEqualTo(8000);
        });
    }

    @Test
    void readLottoNumbers() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5,6");
            assertThat(reader.readLottoNumbers()).containsExactly(1,2,3,4,5,6);
        });
    }

    @Test
    void readBonusNumber() {
        assertSimpleTest(() -> {
            run("7");
            assertThat(reader.readBonusNumber()).isEqualTo(7);
        });
    }

    @Override
    protected void runMain() {

    }
}