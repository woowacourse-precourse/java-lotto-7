package lotto.temp;

import lotto.util.CommonIo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTempTest {
    private LottoTemp lottoTemp;

    @BeforeEach
    void setUp() {
        lottoTemp = new LottoTemp(new CommonIo());
    }

    @Test
    @DisplayName("입력받은 구입 금액에 맞는 구입 숫자를 반환하는지 테스트")
    void purchaseTicket(){
        assertThat(lottoTemp.convertMoneyToTicket(8000)).isEqualTo(8);
        assertThat(lottoTemp.convertMoneyToTicket(100000)).isEqualTo(100);
        assertThat(lottoTemp.convertMoneyToTicket(5000)).isEqualTo(5);
    }

}