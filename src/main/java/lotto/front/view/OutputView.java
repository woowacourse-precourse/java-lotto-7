package lotto.front.view;

import lotto.front.builder.LottoWinningResultOutputBuilder;
import lotto.front.builder.LottoNumberOutputBuilder;
import lotto.global.dto.response.LottoMatchResponseDTO;
import lotto.global.dto.response.LottoPurchaseResponseDTO;

public class OutputView {
    public void writePurchasedLotto(LottoPurchaseResponseDTO lottoPurchaseResponseDTO) {
        System.out.println(LottoNumberOutputBuilder.build(lottoPurchaseResponseDTO.lottoNumberSets()));
    }

    public void writeWinningStats(LottoMatchResponseDTO lottoMatchResponseDTO) {
        System.out.println(LottoWinningResultOutputBuilder.build(lottoMatchResponseDTO.winningCount(),
                lottoMatchResponseDTO.rateOfReturn()));
    }
}
