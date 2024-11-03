package lotto.domain;

import static lotto.domain.LottoConstants.NOT_VALIDATE_NUMBER;

public class LottoPurchase {
    private final LottoPrice lottoPrice;
    private final LottoCount lottoCount;

    public LottoPurchase(String gameMoney) {
        this(convertToInt(gameMoney));
    }

    public LottoPurchase(int gameMoney) {
        this.lottoPrice = new LottoPrice(gameMoney);
        this.lottoCount = new LottoCount(lottoPrice);
    }

    private static int convertToInt(String input) {
        try {
            System.out.println(input);
            int number = Integer.parseInt(input.trim());
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_VALIDATE_NUMBER);
        }
    }

    public int getLottoCount() {
        return lottoCount.getCount();
    }

    public String calculateEarnRate(int prizeMoney) {
        double rate = (double) prizeMoney / lottoPrice.getgameMoney();
        return String.format("%.1f", rate * 100);
    }
}
