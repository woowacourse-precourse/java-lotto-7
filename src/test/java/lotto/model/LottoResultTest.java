package lotto.model;

import lotto.constant.LottoGrade;
import lotto.dto.LottoDto;
import lotto.util.generator.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoManager lottoManager;
    private LottoResult lottoResult;

    private static class FixedNumberGenerator implements NumberGenerator<List<Integer>> {
        @Override
        public List<Integer> generate() {
            return List.of(1, 2, 3, 4, 5, 6);
        }
    }

    @BeforeEach
    void setUp() {
        LottoMachine lottoMachine = new LottoMachine(new FixedNumberGenerator());
        lottoManager = new LottoManager(lottoMachine);
        lottoResult = new LottoResult(List.of(1, 2, 3, 4, 5, 6), 7, lottoManager);
    }

    @Test
    @DisplayName("로또 1등 당첨을 확인한다.")
    void 로또_1등_당첨을_확인한다() {
        LottoDto firstGradeLottoDto = new LottoDto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoGrade grade = lottoResult.calculateGrade(firstGradeLottoDto);
        assertThat(grade).isEqualTo(LottoGrade.FIRST);
    }

    @Test
    @DisplayName("로또 2등 당첨을 확인한다.")
    void 로또_2등_당첨을_확인한다() {
        LottoDto secondGradeLottoDto = new LottoDto(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        LottoGrade grade = lottoResult.calculateGrade(secondGradeLottoDto);
        assertThat(grade).isEqualTo(LottoGrade.SECOND);
    }

    @Test
    @DisplayName("로또 3등 당첨을 확인한다.")
    void 로또_3등_당첨을_확인한다() {
        LottoDto thirdGradeLottoDto = new LottoDto(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        LottoGrade grade = lottoResult.calculateGrade(thirdGradeLottoDto);
        assertThat(grade).isEqualTo(LottoGrade.THIRD);
    }

    @Test
    @DisplayName("로또 4등 당첨을 확인한다.")
    void 로또_4등_당첨을_확인한다() {
        LottoDto fourthGradeLottoDto = new LottoDto(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        LottoGrade grade = lottoResult.calculateGrade(fourthGradeLottoDto);
        assertThat(grade).isEqualTo(LottoGrade.FOURTH);
    }

    @Test
    @DisplayName("로또 5등 당첨을 확인한다.")
    void 로또_5등_당첨을_확인한다() {
        LottoDto fifthGradeLottoDto = new LottoDto(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        LottoGrade grade = lottoResult.calculateGrade(fifthGradeLottoDto);
        assertThat(grade).isEqualTo(LottoGrade.FIFTH);
    }

    @Test
    @DisplayName("로또 낙첨을 확인한다.")
    void 로또_닉을_확인한다() {
        LottoDto noMatchLottoDto = new LottoDto(new Lotto(List.of(8, 9, 10, 11, 12, 13)));
        LottoGrade grade = lottoResult.calculateGrade(noMatchLottoDto);
        assertThat(grade).isEqualTo(LottoGrade.NONE);
    }
}
