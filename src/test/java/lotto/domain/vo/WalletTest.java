package lotto.domain.vo;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.entity.Lotto;
import lotto.domain.factory.LottoFactory;

public class WalletTest {
    @Test
    @DisplayName("구입 금액에 따라 로또를 발급한다")
    void walletShouldGenerateLottoByPurchaseAmount() {
        PurchaseAmount amount = PurchaseAmount.from("10000");
        Wallet wallet = Wallet.from(amount);

        assertThat(wallet.lottos().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("내부의 로또 리스트는 생성 시점에 불변 리스트로 복사되어 저장된다")
    void walletShouldManageLottosImmutably() {
        PurchaseAmount amount = PurchaseAmount.from("10000");
        Lotto lotto = LottoFactory.createAutoLotto();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Wallet wallet = new Wallet(amount, lottos);
        lottos.add(lotto);

        assertThat(wallet.lottos()).hasSize(1);
        assertThat(lottos).hasSize(2);
    }
}
