package lotto.common.model;

public record PriceToBuyLotto (Integer price){
    public static PriceToBuyLotto of (String input){
        return new PriceToBuyLotto(Integer.parseInt(input));
    }
}
