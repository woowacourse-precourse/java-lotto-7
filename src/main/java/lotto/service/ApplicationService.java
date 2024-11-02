package lotto.service;

import lotto.domain.PurchaseAmount;

public class ApplicationService {
    private final UserInputService userInputService;

    public ApplicationService() {
        this.userInputService = new UserInputService();
    }

    public void run() {
        PurchaseAmount purchaseAmount = this.userInputService.createPurchaseAmount();
    }
}
