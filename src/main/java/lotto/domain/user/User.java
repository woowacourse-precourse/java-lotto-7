package lotto.domain.user;

import lotto.collection.Lotto;
import lotto.collection.LottoTickets;
import lotto.enums.LottoConstant;
import lotto.util.LottoWinningPriceList;
import lotto.util.UserIdGenerator;
import lotto.util.Validator;

public class User {

    private final int id;
    private final int purchasePrice;
    private final LottoTickets lottoTickets;
    private double revenue;

    public User(String purchasePrice) {
        validate(purchasePrice);
        this.id = UserIdGenerator.generateId();
        this.purchasePrice = Integer.parseInt(purchasePrice);
        this.lottoTickets = new LottoTickets();
        this.revenue = 0.0;
    }

    private void validate(String purchasePrice) {
        Validator.checkPurchasePrice(purchasePrice);
    }

    // setter
    public void addLotto(Lotto lotto) {
        this.lottoTickets.addLotto(lotto);
    }

    public void addRevenue(int[][] matchCount) {
        long totalReturn = calculateTotalReturn(matchCount);
        double revenue = generateRevenue(totalReturn);

        // 수익률이 음수일 경우 100.0을 더함
        if(revenue < 0.0) {
            revenue += 100.0;
        }
        this.revenue = revenue;
    }

    private long calculateTotalReturn(int[][] matchCount) {
        long totalReturn = 0;

        for (int i = 3; i <= LottoConstant.COUNT.getValue(); i++) {
            long winningPrice = LottoWinningPriceList.get[i];
            totalReturn += (winningPrice * matchCount[i][0]);
        }

        // 보너스 당첨 처리
        if (matchCount[LottoConstant.BONUS_MATCH_COUNT.getValue()][1] != 0) {
            totalReturn += (LottoWinningPriceList.getIncludeBonus * matchCount[LottoConstant.BONUS_MATCH_COUNT.getValue()][1]);
        }

        return totalReturn;
    }

    private double generateRevenue(long totalReturn) {
        double originalRevenue = ((double) (totalReturn - purchasePrice) / purchasePrice) * 100;
        return Math.round(originalRevenue * 10.0) / 10.0;
    }

    // getter
    public int getId() {
        return id;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public double getRevenue() {
        return revenue;
    }
}
