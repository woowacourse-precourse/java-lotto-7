package lotto.exception;

public class LottoNotPurchasedException extends IllegalStateException {
    public LottoNotPurchasedException(String message) {
        super("[ERROR] " + message);
    }
}