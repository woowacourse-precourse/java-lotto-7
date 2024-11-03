package lotto.dto.request;

public record LottoAmountRequest(
        int amount
) {
    public static LottoAmountRequest from(int amount) {
        return new LottoAmountRequest(amount);
    }
}