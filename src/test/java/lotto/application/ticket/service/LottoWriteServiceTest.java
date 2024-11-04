package lotto.application.ticket.service;


import lotto.application.ticket.domain.payment.LottoQuantity;
import lotto.application.ticket.domain.ticket.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoWriteService - 로또 생성 서비스")
class LottoWriteServiceTest {

    @DisplayName("로또 생성 성공")
    @Test
    void 로또_생성_성공() {
        // given
        UniqueNumberGenerator uniqueNumberGenerator = new UniqueNumberGenerator();
        LottoWriteService lottoWriteService = new LottoWriteService(uniqueNumberGenerator);

        LottoQuantity lottoQuantity = LottoQuantity.of(5);

        // when
        Lottos lottos = lottoWriteService.create(lottoQuantity);

        // then
        Assertions.assertThat(lottos.getLottosSize()).isEqualTo(5);
    }

}
