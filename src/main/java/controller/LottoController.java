package controller;

import dto.LottoWinningNumbers;
import dto.lottoDto.LottoResponse;
import dto.lottoWinningResultDto.LottoWinningResultResponse;
import java.util.List;
import model.Lotto;
import model.Money;

public interface LottoController {
    /*
    컨트롤러는 비지니스 로직들의 흐름을 보여주어야 한다.
     */
    /*
    전체적인 흐름 제어 → runLottoProgram
     */

    /*
    0. part1 → issueLottoRun
    1. 사용자에게 금액 입력 → issueLottoStart
    2. 로또 발행          → issueLottoProgress
    3. 발행 결과 출력      → issueLottoEnd


    0. part2 → analyzeLottoRun
    1. 로또 당첨 번호 입력   → analyzeLottoStart
    2. 로또 보너스 번호 입력 → analyzeLottoProgress
    3. 로또 분석 결과 출력   → analyzeLottoEnd
     */

    // About Lotto Program
    public void runLottoProgram();

    // Issue Lotto
    public List<Lotto> runIssueLotto();

    // return LottoRequest
    // view → (controller) → model
    public Money issueLottoStart();

    // return LottoResult
    // model → (controller) → service
    public LottoResponse issueLottoProgress(Money money);

    // return LottoResponse
    // service → (controller) → view
    public void issueLottoEnd(LottoResponse lottoResponse);


    // Analyze Lotto
    public void runAnalyzeLotto(List<Lotto> issuedLotto);

    // view → (controller) → model
    public LottoWinningNumbers analyzeLottoStart();

    // 당첨 개수와 수익률 계산
    // model → (controller) → service
    public LottoWinningResultResponse analyzeLottoProgress(LottoWinningNumbers lottoWinningNumbers,
                                                           List<Lotto> issuedLotto);

    // return LottoResultResponse → 고민좀...
    // service → (controller) → view
    public void analyzeLottoEnd(LottoWinningResultResponse lottoWinningResultResponse);
}
