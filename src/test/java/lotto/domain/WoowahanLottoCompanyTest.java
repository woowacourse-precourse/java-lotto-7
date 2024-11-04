package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.errorMessage.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WoowahanLottoCompanyTest {

    @DisplayName("존재하는 로또 머신을 다른 이용자가 먼저 사용중일 경우 실패 테스트")
    @Test
    void availableMachineFailTest() {
        WoowahanLottoCompany company = new WoowahanLottoCompany();
        Consumer consumer = new Consumer();
        Consumer anotherConsumer = new Consumer();

        company.startUseMachin(consumer);

        assertThatThrownBy(() -> company.startUseMachin(anotherConsumer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NO_AVAILABLE_MACHIN.getErrorMessage());
    }
}