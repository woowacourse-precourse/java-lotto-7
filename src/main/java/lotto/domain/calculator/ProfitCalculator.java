package lotto.domain.calculator;

import lotto.dto.ProfitDto;

public class ProfitCalculator implements Calculator<ProfitDto, Double>{

    @Override
    public Double calculate(ProfitDto profitDto) {
        int totalProfit = profitDto.getLottoResult().entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double profitRate = ((double) totalProfit / profitDto.getReceipt().getPurchaseAmount()) * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
