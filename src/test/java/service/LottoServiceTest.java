package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.LottoList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("로또 개수 구하는 함수 정상 작동 테스트")
    @Test
    void getPurchasedLottoCountTest() {
        assertThat(lottoService.getCount("8000").getPurchaseCount()).
                isEqualTo(8);
    }

    @DisplayName("입력 금액이 정수가 아닌 경우")
    @Test
    void getPurchasedLottoCount_Not_Number() {
        String Not_Num = "this is not number";
        assertThatThrownBy(() -> {
            lottoService.getCount(Not_Num);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 숫자로 입력해야 합니다.");
    }

    @DisplayName("구입 개수가 1개 미만인 경우")
    @Test
    void getPurchasedLottoCount_Negative_Amount() {
        String Negative_Amount = "-1000";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lottoService.getCount(Negative_Amount);
                }).withMessageMatching("\\[ERROR\\] 금액은 1000 이상이어야 합니다\\.");
    }

    @DisplayName("구입 금액이 1000단위가 아닌 경우")
    @Test
    void getPurchasedLottoCount_NonThousandUnitAmount() {
        String NonThousandUnitAmount = "1111";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lottoService.getCount(NonThousandUnitAmount);
                }).withMessageMatching("\\[ERROR\\] 금액은 1000원 단위로 입력해야 합니다\\.");
    }

    @DisplayName("구매 개수에 맞게 로또 리스트가 생성되는지 테스트")
    @Test
    void generateLottosTest() {
        int purchaseCount = 5;
        LottoList lottoList = lottoService.generateLottos(purchaseCount);

        assertThat(lottoList.size()).isEqualTo(purchaseCount);
    }
}