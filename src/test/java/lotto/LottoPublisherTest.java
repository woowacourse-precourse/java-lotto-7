package lotto;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPublisherTest {
    @Test
    void 발행을_요청한_개수만큼_로또가_발행_되어야_한다() {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount("8000");
        List<Lotto> lottos = LottoPublisher.publishLotto(purchaseAmount);

        //when & then
        assertThat(lottos).hasSize(8);
    }

    @Test
    void 발행한_로또는_오름차순으로_정렬_되어야_한다() {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount("1000");
        List<Lotto> lottos = LottoPublisher.publishLotto(purchaseAmount);

        //then
        List<Integer> numbers = lottos.getFirst().getLottoNumbers(); // 첫 번째 로또 번호 가져오기
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Integer::compareTo); // 정렬된 리스트 만들기

        assertThat(numbers).isEqualTo(sortedNumbers);
    }

}