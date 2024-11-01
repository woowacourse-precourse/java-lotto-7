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

    private static final double ZERO = 0.0;
    private static final double PERCENTAGE_CONVERSION = 100.0;
    private final List<Lotto> lottos;
    private final Map<LottoGrade, Integer> result = new EnumMap<>(LottoGrade.class);
    private final int amountUnit;

    public LottoBuyer(int amount, LottoManager lottoManager) {
        this(amount, lottoManager, AMOUNT_UNIT);
    }

    public LottoBuyer(int amount, LottoManager lottoManager, int amountUnit) {
        this.lottos = lottoManager.createLottoTickets(amount);
        this.amountUnit = amountUnit;
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
        double totalAmount = calculateTotalWinnings();
        return calculateReturnOnInvestment(totalAmount);
    }

    private double calculateTotalWinnings() {
        return result.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().getAmount() * entry.getValue())
                .sum();
    }

    private double calculateReturnOnInvestment(double amount) {
        if (amount == ZERO) {
            return ZERO;
        }
        return (amount / (lottos.size() * amountUnit)) * PERCENTAGE_CONVERSION;
    }

    public List<LottoNumberListDto> getLottos() {
        return lottos.stream()
                .map(LottoNumberListDto::from)
                .toList();
    }
}
