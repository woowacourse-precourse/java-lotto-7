package lotto.back.domain;

import java.util.List;
import lotto.global.exception.InvalidLottoPriceUnitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.*;

class LottoIssuerTest {
    private final LottoIssuer lottoIssuer = new LottoIssuer();

    @Test
    @DisplayName("1,000원 단위 가격이 들어왔을 때 로또 리스트 생성 테스트, 로또 객체가 생성되고 로또 번호들은 오름차순으로 정렬")
    void 로또_리스트_생성_테스트() {
        //given
        Integer price = 2000;
        List<Integer> lottoNumbers1 = List.of(10, 21, 24, 34, 20, 1);
        List<Integer> lottoNumbers2 = List.of(23, 24, 45, 35, 34, 11);
        //when
        assertRandomUniqueNumbersInRangeTest(() -> {
            List<Lotto> lottos = lottoIssuer.issueByPrice(price);
            // 정렬된 상태로 로또 번호들이 존재해야함.
            List<Integer> sortedLottoNumbers1 = lottoNumbers1.stream().sorted().toList();
            List<Integer> sortedLottoNumbers2 = lottoNumbers2.stream().sorted().toList();
            //then
            assertThat(lottos.size()).isEqualTo(2);
            assertThat(lottos.get(0).getLottoNumbers()).containsExactlyElementsOf(sortedLottoNumbers1);
            assertThat(lottos.get(1).getLottoNumbers()).containsExactlyElementsOf(sortedLottoNumbers2);
        }, lottoNumbers1, lottoNumbers2);
    }

    @Test
    @DisplayName("1,000원 단위 가격이 아닌 양의정수가 들어왔을 때 예외 테스트")
    void 로또_리스트_예외_테스트1() {
        //given
        Integer price = 1200;
        //when
        //then
        assertThatThrownBy(() -> lottoIssuer.issueByPrice(price)).isInstanceOf(InvalidLottoPriceUnitException.class);
    }

    @Test
    @DisplayName("1,000원 단위 가격이 아닌 음의정수가 들어왔을 때 예외 테스트")
    void 로또_리스트_예외_테스트2() {
        //given
        Integer price = -1200;
        //when
        //then
        assertThatThrownBy(() -> lottoIssuer.issueByPrice(price)).isInstanceOf(InvalidLottoPriceUnitException.class);
    }
}