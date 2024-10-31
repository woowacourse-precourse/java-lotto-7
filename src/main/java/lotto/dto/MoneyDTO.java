package lotto.dto;

public record MoneyDTO(Long money) {
    public static MoneyDTO from(Long money){
        return new MoneyDTO(money);
    }
}
