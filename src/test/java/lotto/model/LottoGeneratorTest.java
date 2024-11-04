package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 생성 테스트")
class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    @DisplayName("발행한 로또가 로또의 객체인지 확인하는 테스트")
    void createLottoInstance() {
        assertThat(lottoGenerator.createSingleLotto()).isInstanceOf(Lotto.class);
    }

    @ParameterizedTest
    @CsvSource({"5,5", "1,1", "100,100"})
    @DisplayName("구입 숫자만큼 로또를 발행하는지 확인하는 테스트")
    void issueTicketByCount(int ticketCount, int size) {
        assertThat(lottoGenerator.createMultipleLottos(ticketCount)).hasSize(size);
    }

}