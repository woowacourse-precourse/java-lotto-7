package lotto.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoIssuerTest {

    @Test
    void 유효한_금액으로_객체가_정상적으로_생성된다() {
        LottoIssuer issuer = new LottoIssuer(5000);
        assertThat(issuer.getAmount()).isEqualTo(5000);
        assertThat(issuer.getCount()).isEqualTo(5);
        assertThat(issuer.getAllIssuedLotto().size()).isEqualTo(5);
    }

    @Test
    void 금액이_0_이하일_때_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoIssuer(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_최소_로또_가격_미만일_때_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoIssuer(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 발급된_로또는_정렬된_상태로_저장된다() {
        LottoIssuer issuer = new LottoIssuer(5000);
        for (List<Integer> lotto : issuer.getAllIssuedLotto()) {
            assertThat(lotto).isSorted();
        }
    }
}
