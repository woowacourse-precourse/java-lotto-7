package lotto;

public interface LottoPlaceDecidable {

    LottoPlace decide();

    boolean supports(int matchingCount, boolean hasBonusNumber);
}
