package lotto.controller;

public class TotalController {

    private static TotalController instance;

    private final ScreenController screenController = new ScreenController();

    public void activate() {
        buy();
        prizeCheck();
    }

    private void buy() {
        PurchaseController.getController().run();
        screenController.printMyLottery();
    }

    private void prizeCheck() {
        HostController.getController().run();
        screenController.printMyResult();
        screenController.profitRate();
    }

    public static TotalController getController() {
        if (instance == null) {
            instance = new TotalController();
        }
        return instance;
    }
}