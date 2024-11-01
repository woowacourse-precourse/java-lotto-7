package lotto.model;

import static lotto.model.LottoManager.AMOUNT_UNIT;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.constant.LottoGrade;
import lotto.dto.LottoDto;
import lotto.dto.LottoNumberListDto;
import lotto.dto.LottoResultDto;

public class LottoBuyer {

    private final List<Lotto> lottos;
    private final Map<LottoGrade, Integer> result = new EnumMap<>(LottoGrade.class);

    public LottoBuyer(int amount, LottoManager lottoManager) {
        lottos = lottoManager.createLottoTickets(amount);
        initializeResult();
    }

    private void initializeResult() {
        for (LottoGrade lottoGrade : LottoGrade.values()) {
            result.put(lottoGrade, 0);
        }
    }

    public List<LottoResultDto> calculateResult(LottoResult lottoResult) {
        for (Lotto lotto : lottos) {
            LottoDto lottoDto = lotto.toDto();

            LottoGrade lottoGrade = lottoResult.calculateGrade(lottoDto);

            if (lottoGrade != LottoGrade.NONE) {
                result.put(lottoGrade, result.get(lottoGrade) + 1);
            }
        }
        return createResultsDto();
    }

    private List<LottoResultDto> createResultsDto() {
        return result.keySet()
                .stream()
                .map(grade -> LottoResultDto.of(grade, result.get(grade)))
                .toList();
    }

    public double returnOnInvestment() {
        double amount = 0;
        for (Map.Entry<LottoGrade, Integer> entry : result.entrySet()) {
            Integer winningCount = entry.getValue();
            if (winningCount > 0) {
                amount += entry.getKey().getAmount() * winningCount;
            }
        }
        return calculateReturnOnInvestment(amount);
    }

    private double calculateReturnOnInvestment(double amount) {
        if (amount == 0) {
            return amount;
        }
        return (amount / (lottos.size() * AMOUNT_UNIT)) * 100;
    }

    public List<LottoNumberListDto> getLottos() {
        return lottos.stream()
                .map(LottoNumberListDto::from)
                .toList();
    }
}