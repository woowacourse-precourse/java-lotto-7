package lotto.dto;

public record PurchaseAmountDto(
        int purchaseAmount
) {

    public static PurchaseAmountDto from(String input){
        return new PurchaseAmountDto(Integer.parseInt(input));
    }
}
