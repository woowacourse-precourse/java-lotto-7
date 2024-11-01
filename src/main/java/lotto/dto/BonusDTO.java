package lotto.dto;

public record BonusDTO(Integer number) {
    public static BonusDTO from(String input) {
        return new BonusDTO(Integer.valueOf(input));
    }
}
