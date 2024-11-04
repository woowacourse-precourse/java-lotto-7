package lotto.back.service.impl;

import java.util.List;
import java.util.Map;
import lotto.back.service.LottoService;
import lotto.global.dto.request.LottoDrawRequestDTO;
import lotto.global.dto.request.LottoMatchRequestDTO;
import lotto.global.dto.request.LottoPurchaseRequestDTO;
import lotto.global.dto.response.LottoMatchResponseDTO;
import lotto.global.dto.response.LottoPurchaseResponseDTO;
import lotto.global.enums.WinningLottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.*;
import static lotto.global.enums.WinningLottoRank.*;

class LottoServiceImplTest {

    private final LottoService lottoService = new LottoServiceImpl();

    @Test
    @DisplayName("로또 구입 금액에 대한 로또 생성 테스트")
    void 로또_구입_테스트() {
        //given
        LottoPurchaseRequestDTO requestDTO = new LottoPurchaseRequestDTO(2000);
        //when
        assertRandomUniqueNumbersInRangeTest(() -> {
            LottoPurchaseResponseDTO responseDTO = lottoService.issueLottos(requestDTO);
            List<List<Integer>> lottoNumberSets = responseDTO.lottoNumberSets();
            //then
            assertThat(lottoNumberSets.size()).isEqualTo(2);
            assertThat(lottoNumberSets.get(0)).containsExactly(10, 12, 32, 43, 44, 45);
            assertThat(lottoNumberSets.get(1)).containsExactly(10, 12, 32, 43, 44, 45);
        }, List.of(10, 12, 32, 43, 44, 45), List.of(10, 12, 32, 43, 44, 45));
    }

    @Test
    @DisplayName("로또 구입, 추첨 번호 등록, 보너스 번호에 따른 로또 당첨 결과 반환 테스트")
    void 로또_추첨_및_당첨확인_테스트() {
        //given
        LottoPurchaseRequestDTO lottoPurchaseRequestDTO = new LottoPurchaseRequestDTO(2000);
        LottoDrawRequestDTO lottoDrawRequestDTO = new LottoDrawRequestDTO(List.of(1, 2, 3, 4, 5, 6));
        LottoMatchRequestDTO lottoMatchRequestDTO = new LottoMatchRequestDTO(7);
        Double expectedRateOfReturn = (double) (SECOND_PLACE.getPrizeMoney() + FIRST_PLACE.getPrizeMoney()) / 2000.0 * 100.0;
        //when
        assertRandomUniqueNumbersInRangeTest(() -> {
            lottoService.issueLottos(lottoPurchaseRequestDTO);
            lottoService.saveDrawnNumbers(lottoDrawRequestDTO);
            LottoMatchResponseDTO lottoMatchResponseDTO = lottoService.matchLotto(lottoMatchRequestDTO);

            Map<WinningLottoRank, Integer> winningCount = lottoMatchResponseDTO.winningCount();
            Double rateOfReturn = lottoMatchResponseDTO.rateOfReturn();
            //then
            assertThat(winningCount.get(FIRST_PLACE)).isEqualTo(1); // 1등 1번
            assertThat(winningCount.get(SECOND_PLACE)).isEqualTo(1); // 2등 1번
            assertThat(winningCount.entrySet().stream() // 나머지 모두 0번 당첨
                    .filter(entry -> (entry.getKey() != FIRST_PLACE && entry.getKey() != SECOND_PLACE))
                    .allMatch(entry -> entry.getValue() == 0)).isTrue();

            assertThat(rateOfReturn).isEqualTo(expectedRateOfReturn); // 수익률

        }, List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7));
    }
}