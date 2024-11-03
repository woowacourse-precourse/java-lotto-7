package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import lotto.policy.LottoNumberPolicy;
import lotto.policy.PrizeMoneyPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PolicyServiceTest {

    private PolicyService policyService;

    @BeforeEach
    void setUp() {
        policyService = new PolicyService();
    }

    @Test
    @DisplayName("로또 번호 스케일(6) 테스트")
    void 로또_번호_스케일(){
        //given
        int expectation = 6;
        //then
        int lottoNumberScale = LottoNumberPolicy.NUMBER_SCALE.number();
        //when
        assertThat(expectation).isEqualTo(lottoNumberScale);
    }

    @Test
    @DisplayName("로또 번호 최대값(45) 테스트")
    void 로또_번호_최대값(){
        //given
        int expectation = 45;
        //then
        int lottoMaxNumber = policyService.getLottoMaxNumber();
        //when
        assertThat(expectation).isEqualTo(lottoMaxNumber);
    }

    @Test
    @DisplayName("로또 번호 최소값(1) 테스트")
    void 로또_번호_최소값(){
        //given
        int expectation = 1;
        //then
        int lottoMaxNumber = policyService.getLottoMinNumber();
        //when
        assertThat(expectation).isEqualTo(lottoMaxNumber);
    }

    @Test
    @DisplayName("로또 티켓값(1,000원) 테스트")
    void 로또_티켓값_테스트(){
        //given
        int expectation = 1000;
        //then
        int ticketPrice = policyService.getLottoTicketPrice();
        //when
        assertThat(expectation).isEqualTo(ticketPrice);
    }

    @ParameterizedTest(name = "로또 숫자 일치 개수 : {0}, 상금 : {1} ")
    @DisplayName("4개 일치_50,000원 테스트")
    @MethodSource("matchedNumberAndMoney")
    void 일치_테스트(int number, int money, boolean bonusMatch){
        //then
        PrizeMoneyPolicy result = policyService.getRankAndPrizeMoney(number, bonusMatch);
        //when
        assertThat(number).isEqualTo(result.getMatchedCount());
        assertThat(money).isEqualTo(result.getPriceMoney());
    }

    static Stream<Arguments> matchedNumberAndMoney(){
        return Stream.of(
                Arguments.arguments(6, 2_000_000_000, false),
                Arguments.arguments(5, 30_000_000, true),
                Arguments.arguments(5, 1_500_000, false),
                Arguments.arguments(4, 50_000, false),
                Arguments.arguments(3, 5_000, false),
                Arguments.arguments(0, 0, false)
        );
    }
}