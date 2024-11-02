package lotto.model;

import lotto.constant.LottoGrade;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoNumberListDto;
import lotto.util.generator.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBuyerTest {

    private LottoBuyer lottoBuyer;
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
        LottoManager lottoManager = new LottoManager(lottoMachine);
        lottoBuyer = new LottoBuyer(1000, lottoManager);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoResult = new LottoResult(winningNumbers, bonusNumber, lottoManager);
    }

    @Test
    @DisplayName("LottoBuyer 객체가 정상적으로 생성된다.")
    void LottoBuyer_객체가_정상적으로_생성된다() {
        assertThat(lottoBuyer.getLottos()).isNotEmpty();
    }

    @Test
    @DisplayName("LottoBuyer가 당첨 결과를 계산한다.")
    void LottoBuyer가_당첨_결과를_계산한다() {
        List<LottoResultDto> resultDtos = lottoBuyer.calculateResult(lottoResult);

        assertThat(resultDtos).isNotEmpty();
        assertThat(resultDtos.stream().anyMatch(dto -> dto.grade() == LottoGrade.FIRST)).isTrue();
    }

    @Test
    @DisplayName("LottoBuyer가 투자 대비 수익률을 계산한다.")
    void 투자_대비_수익률을_계산한다() {
        lottoBuyer.calculateResult(lottoResult);

        double roi = lottoBuyer.returnOnInvestment();
        assertThat(roi).isGreaterThan(0);
    }

    @Test
    @DisplayName("로또 번호 리스트 DTO를 반환한다.")
    void 로또_번호_리스트_DTO를_반환한다() {
        List<LottoNumberListDto> lottoDtos = lottoBuyer.getLottos();

        assertThat(lottoDtos).isNotEmpty();
        assertThat(lottoDtos.get(0).numbers().size()).isEqualTo(6);
    }
}
