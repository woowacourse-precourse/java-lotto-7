package lotto.controller;

import lotto.Service.MarginService;

public class MarginController {
    public static void run(int money, int payment) {
        MarginService marginService = new MarginService();
        marginService.setSellingPrice(money);
        marginService.setCostPrice(payment);
        marginService.calculateProfitMargin();
        marginService.displayResult();
    }
}
