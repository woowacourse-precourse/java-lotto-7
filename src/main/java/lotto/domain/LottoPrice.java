package lotto.domain;

import java.util.Arrays;

public enum LottoPrice {

    NONE(0, 0, false, 0, ""),
    FIFTH(5, 3, false, 5_000, "(5,000원)"),
    FOURTH(4, 4, false, 50_000, "(50,000원)"),
    THIRD(3, 5, false, 1_500_000, "(1,500,000원)"),
    SECOND(2, 5, true, 30_000_000, "(30,000,000원)"),
    FIRST(1, 6, false, 2_000_000_000, "(2,000,000,000원)");

    private final int price;
    private final int matchesNumber;
    private final boolean bonusNumber;
    private final int priceMoney;
    private final String priceMessage;


    LottoPrice(int price, int matchesNumber, boolean bonusNumber, int priceMoney, String priceMessage) {
        this.price = price;
        this.matchesNumber = matchesNumber;
        this.bonusNumber = bonusNumber;
        this.priceMoney = priceMoney;
        this.priceMessage = priceMessage;
    }

    public static LottoPrice getLottoPrice(int matchesNumber, boolean bonusNumber) {
        return Arrays.stream(LottoPrice.values())
                .filter(lottoPrice -> lottoPrice.matchesNumber == matchesNumber)
                .filter(lottoPrice -> lottoPrice.bonusNumber == bonusNumber)
                .findFirst()
                .orElse(NONE);
    }

    public static LottoPrice getLottoPriceByPrice(int price) {
        return Arrays.stream(LottoPrice.values())
                .filter(lottoPrice -> lottoPrice.price == price)
                .findFirst()
                .orElse(NONE);
    }

    public static String toString(int price) {
        LottoPrice lottoPrice = getLottoPriceByPrice(price);
        return formatPriceMessage(lottoPrice);
    }

    private static String formatPriceMessage(LottoPrice lottoPrice) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottoPrice.matchesNumber).append("개 일치");
        if (lottoPrice.equals(SECOND)) sb.append(", 보너스 볼 일치");
        sb.append(" ").append(lottoPrice.getPriceMessage());
        return sb.toString();
    }

    public int getPrice() {
        return price;
    }

    public String getPriceMessage() {
        return priceMessage;
    }

    public int getPriceMoney() {
        return priceMoney;
    }

}
