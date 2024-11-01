package lotto.dto;

public record BonusNumberDto(
        int bonusNumber
) {

    public static BonusNumberDto from(String input){
        return new BonusNumberDto(Integer.parseInt(input));
    }
}
