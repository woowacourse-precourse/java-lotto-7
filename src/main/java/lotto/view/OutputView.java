package lotto.view;

import lotto.dto.lottoDto.LottoResponse;
import lotto.dto.lottoWinningResultDto.LottoWinningResultResponse;

public interface OutputView {

    void printIssuedLotto(LottoResponse lottoResponse);

    void printLottoResult(LottoWinningResultResponse lottoWinningResultResponse);
}
