package lotto.dto;

public record InputMoneyDTO(Integer money) {
    public static InputMoneyDTO from(Integer money){
        return new InputMoneyDTO(money);
    }
}
