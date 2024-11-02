package lotto.temp;

import lotto.Lotto;
import lotto.util.CommonIo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("발행한 로또가 로또의 객체인지 확인하는 테스트")
    void createLottoInstance(){
        assertThat(lottoTemp.createSingleLotto()).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("구입 숫자만큼 로또를 발행하는지 확인하는 테스트")
    void issueTicketByCount(){
        assertThat(lottoTemp.createMultipleLottos(5)).hasSize(5);
        assertThat(lottoTemp.createMultipleLottos(1)).hasSize(1);
        assertThat(lottoTemp.createMultipleLottos(100)).hasSize(100);
    }

}