package lotto.handler.statistics.dto;

public class ProfitRateDTO {
    private String profitRate;

    private ProfitRateDTO(String profitRate) {
        this.profitRate = profitRate;
    }

    public String getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(String profitRate) {
        this.profitRate = profitRate;
    }


    public static ProfitRateDTO create(String profitRate) {
        return new ProfitRateDTO(profitRate);
    }
}
