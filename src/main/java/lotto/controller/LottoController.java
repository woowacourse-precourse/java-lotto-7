package lotto.controller;

import java.util.List;
import lotto.dto.LottoWinningNumbers;
import lotto.dto.lottoDto.LottoResponse;
import lotto.dto.lottoWinningResultDto.LottoWinningResultResponse;
import lotto.model.Lotto;
import lotto.model.Money;

public interface LottoController {
    // About Lotto Program
    void runLottoProgram();

    // Issue Lotto
    List<Lotto> runIssueLotto();

    Money issueLottoStart();

    LottoResponse issueLottoProgress(Money money);

    void issueLottoEnd(LottoResponse lottoResponse);

    // Analyze Lotto
    void runAnalyzeLotto(List<Lotto> issuedLotto);

    LottoWinningNumbers analyzeLottoStart();

    LottoWinningResultResponse analyzeLottoProgress(LottoWinningNumbers lottoWinningNumbers,
                                                    List<Lotto> issuedLotto);

    void analyzeLottoEnd(LottoWinningResultResponse lottoWinningResultResponse);
}
