package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class IssuerTest {
    private Issuer issuer;

    @Test
    public void 로또가_개수에_맞게_잘_생성되는지_확인한다() {
        issuer = new Issuer();

        Lottos lottos = new Lottos();
        lottos = issuer.issueLottos(5);

        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }
}
