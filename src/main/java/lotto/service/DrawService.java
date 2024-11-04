package lotto.service;

import java.math.BigDecimal;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoEvaluator;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.WinningNumbersRequestDto;

public class DrawService {

    public WinningNumbers setWinningNumbers(WinningNumbersRequestDto request) {
        return new WinningNumbers(request.mainNumber(), request.bonusNumber());
    }

    public LottoResultResponseDto evaluateLottoResults(LottoBundle lottoBundle, WinningNumbers winningNumbers) {
        LottoEvaluator evaluator = new LottoEvaluator(winningNumbers);

        LottoResult result = evaluator.evaluate(lottoBundle.getLotteries());
        int amount = lottoBundle.getLotteriesSize() * Lotto.LOTTO_PRICE;
        BigDecimal yield = evaluator.calculateYield(result, amount);

        return new LottoResultResponseDto(result, yield);
    }
}
