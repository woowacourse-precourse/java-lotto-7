package lotto.dto;

public class LottoRateDto {
    private final String description;

    private LottoRateDto(String description) {
        this.description = description;
    }

    public static LottoRateDto from(double rate) {
        String description = String.format("총 수익률은 %.1f%%입니다.", rate);
        return new LottoRateDto(description);
    }

    public String getDescription() {
        return description;
    }
}
