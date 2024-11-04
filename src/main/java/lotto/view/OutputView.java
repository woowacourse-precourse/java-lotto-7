package lotto.view;

import lotto.dto.lottoDto.LottoResponse;
import lotto.dto.lottoWinningResultDto.LottoWinningResultResponse;

public interface OutputView {

    public void printIssuedLotto(LottoResponse lottoResponse);

    public void printLottoResult(LottoWinningResultResponse lottoWinningResultResponse);
}
