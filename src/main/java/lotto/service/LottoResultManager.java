package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.domain.calculator.Calculator;
import lotto.domain.lottoMatchChecker.LottoMatchChecker;
import lotto.dto.entity.Lotto;
import lotto.dto.LottoResultDto;
import lotto.dto.ProfitDto;
import lotto.dto.ReceiptAndLottoDto;
import lotto.dto.entity.WinningLotto;
import lotto.utils.LottoMatchStatus;

public class LottoResultManager {
    private LottoMatchChecker lottoMatchChecker;
    private Calculator calculator;
    public LottoResultManager(LottoMatchChecker lottoMatchChecker, Calculator calculator){
        this.lottoMatchChecker = lottoMatchChecker;
        this.calculator = calculator;
    }
    public LottoResultDto checkLottoResult(ReceiptAndLottoDto receiptAndLottoDto, WinningLotto winningLotto){
        HashMap<LottoMatchStatus,Integer> lottoResult = compareLottos(winningLotto, receiptAndLottoDto.getLottos());
        double profit = calculateProfitRate(new ProfitDto(lottoResult, receiptAndLottoDto.getReceipt()));
        return new LottoResultDto(lottoResult, profit);
    }

    private HashMap<LottoMatchStatus,Integer> compareLottos(WinningLotto winningLotto, List<Lotto> lottos){
        return lottoMatchChecker.countMatchingNumbers(winningLotto, lottos);
    }

    private double calculateProfitRate(ProfitDto profitDto){
        return (double) calculator.calculate(profitDto);
    }
}