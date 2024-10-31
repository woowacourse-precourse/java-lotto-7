package lotto.dto;

public record InputMoneyDTO(Long money) {
    public static InputMoneyDTO from(Long money){
        return new InputMoneyDTO(money);
    }
}
