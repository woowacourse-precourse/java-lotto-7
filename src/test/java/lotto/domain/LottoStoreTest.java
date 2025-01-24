package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {


    @DisplayName("올바른 로또 장수를 가지는지 확인")
    @Test
    void getTicketTest() {
        LottoStore lottoStore = new LottoStore("2000");
        assertEquals(2, lottoStore.getTickets());
    }

    @DisplayName("1000원 단위의 돈이 아닐경우 예외처리")
    @Test
    void getMoneyThousandUnit() {
        String money = "10800";

        assertThatThrownBy(() -> new LottoStore(money)
                .getBonusNumber(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("정수로 된 숫자가 아닌 경우 예외처리")
    @Test
    void getMoneyOnlyNumber() {
        String money = "1000j";

        assertThatThrownBy(() -> new LottoStore(money)
                .getBonusNumber(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("원하는 당첨 번호가 리스트 형식으로 변하는 지 확인")
    @Test
    void winningNumberTest() {
        LottoStore lottoStore = new LottoStore("2000");

        assertEquals(List.of(1, 2, 3, 4, 5, 6),
                lottoStore.getWinningNumber("1,2,3,4,5,6"));
    }


    @DisplayName("당첨 번호와 보너스 번호 중복 에러 테스트")
    @Test
    void checkSameNumberInWinningNumberTest() {
        String bonusNumber = "6";

        assertThatThrownBy(() -> new LottoStore(bonusNumber)
                .checkSameNumberInWinningNumber(List.of(1,2,3,4,5,6),bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 범위 테스트")
    @ParameterizedTest
    @ValueSource(strings = "100")
    void bonusNumberRangeTest(String number) {
        assertThatThrownBy(() -> new LottoStore(number)
                .getBonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
