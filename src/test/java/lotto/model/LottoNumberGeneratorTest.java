package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.policy.BasicPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator(new BasicPolicy());
    }

    @Test
    @DisplayName("1,45 사이의 중복되지 않은 정수 6개 반환")
    public void 여섯개의_정수_리스트_반환(){
        //given
        int size = 6;
        //when
        List<Integer> lottoNumbers = lottoNumberGenerator.generateNumbers();
        //then
        assertThat(lottoNumbers.size()).isEqualTo(size);
    }
}