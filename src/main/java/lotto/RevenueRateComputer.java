package lotto;

import constant.OutputNotice;
import constant.Price;

public class RevenueRateComputer {

    public double computeRevenueRate(long totalRevenue, int boughtTicketCount) {
        long totalPay = (long) boughtTicketCount * Price.LOTTOPRICE.getPrice();
        return Math.round(((double) totalRevenue / totalPay) * 100 * 10) / 10.0;
    }

    public void printRevenueRate(long totalRevenue, int boughtTicketCount) {
        double revenueRate = computeRevenueRate(totalRevenue, boughtTicketCount);
        System.out.println(OutputNotice.TOTAL_REVENUE.show() + revenueRate + "%입니다.");
    }
}
