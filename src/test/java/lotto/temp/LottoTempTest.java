package lotto.temp;

import lotto.Lotto;
import lotto.util.CommonIo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    @DisplayName("입력받은 당첨번호 콤마를 기준으로 분리")
    void separateWinningNumber(){
        assertThat(lottoTemp.createWinningNumbers("1,2,3,4,5,6"))
                .containsExactly(1,2,3,4,5,6);
        assertThat(lottoTemp.createWinningNumbers("3,5,14,26,34,45"))
                .containsExactly(3,5,14,26,34,45);
    }


    @Test
    @DisplayName("구입한 로또와 당첨번호가 몇 개 일치하는지 확인하는 테스트")
    void compareLottos(){
        assertThat(lottoTemp.compareLottos(
                List.of(new Lotto(List.of(1,2,3,4,5,6)),
                        new Lotto(List.of(1,2,3,4,5,7)),
                        new Lotto(List.of(1,2,3,4,7,8)),
                        new Lotto(List.of(1,2,3,7,8,9)),
                        new Lotto(List.of(1,2,7,8,9,10))),
                List.of(1,2,3,4,5,6))).containsExactly(6,5,4,3,2);
    }

    @Test
    @DisplayName("보너스 번호와 로또가 일치하는지 확인하는 테스트")
    void compareBonusNumber(){
        assertThat(lottoTemp.checkBonusNumber(new Lotto(List.of(1,2,3,4,5,6)),6)).isTrue();
        assertThat(lottoTemp.checkBonusNumber(new Lotto(List.of(1,2,3,4,5,6)),7)).isFalse();
    }

    @Test
    @DisplayName("일치하는 개수에 따라 올바른 등수를 나타내는지 확인하는 테스트")
    void confirmLottoRank(){
        assertThat(lottoTemp.determineRank(2,true)).isEqualTo("꽝");
        assertThat(lottoTemp.determineRank(3,true)).isEqualTo("5등");
        assertThat(lottoTemp.determineRank(4,true)).isEqualTo("4등");
        assertThat(lottoTemp.determineRank(5,false)).isEqualTo("3등");
        assertThat(lottoTemp.determineRank(5,true)).isEqualTo("2등");
        assertThat(lottoTemp.determineRank(6,true)).isEqualTo("1등");
    }
}