package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    @DisplayName("발행한 로또가 로또의 객체인지 확인하는 테스트")
    void createLottoInstance(){
        assertThat(lottoGenerator.createSingleLotto()).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("구입 숫자만큼 로또를 발행하는지 확인하는 테스트")
    void issueTicketByCount(){
        assertThat(lottoGenerator.createMultipleLottos(5)).hasSize(5);
        assertThat(lottoGenerator.createMultipleLottos(1)).hasSize(1);
        assertThat(lottoGenerator.createMultipleLottos(100)).hasSize(100);
    }

}