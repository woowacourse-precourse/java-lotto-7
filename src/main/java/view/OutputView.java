package view;

import dto.lottoDto.LottoResponse;
import dto.lottoWinningResultDto.LottoWinningResultResponse;

public interface OutputView {

    public void printIssuedLotto(LottoResponse lottoResponse);

    public void printLottoResult(LottoWinningResultResponse lottoWinningResultResponse);
}
