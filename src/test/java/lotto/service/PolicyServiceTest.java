package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PolicyServiceTest {

    private PolicyService policyService;

    @BeforeEach
    void setUp() {
        policyService = new PolicyService();
    }

    @Test
    @DisplayName("로또 번호 스케일(6) 테스트")
    public void 로또_번호_스케일(){
        //given
        int expectation = 6;
        //then
        int lottoNumberScale = policyService.getLottoNumberScale();
        //when
        assertThat(expectation).isEqualTo(lottoNumberScale);
    }

    @Test
    @DisplayName("로또 번호 최대값(45) 테스트")
    public void 로또_번호_최대값(){
        //given
        int expectation = 45;
        //then
        int lottoMaxNumber = policyService.getLottoMaxNumber();
        //when
        assertThat(expectation).isEqualTo(lottoMaxNumber);
    }

    @Test
    @DisplayName("로또 번호 최소값(1) 테스트")
    public void 로또_번호_최소값(){
        //given
        int expectation = 1;
        //then
        int lottoMaxNumber = policyService.getLottoMinNumber();
        //when
        assertThat(expectation).isEqualTo(lottoMaxNumber);
    }

}