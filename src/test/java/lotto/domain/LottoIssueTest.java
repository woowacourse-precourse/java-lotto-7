package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIssueTest {

    @Test
    void 로또_발행_생성_성공() {
        //given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(21, 22, 23, 24, 25, 26)),
                new Lotto(List.of(31, 32, 33, 34, 35, 36))
        );

        //when
        LottoIssue lottoIssue = new LottoIssue(lottos);

        //then
        assertThat(lottoIssue.getLottos()).isEqualTo(lottos);
    }

}