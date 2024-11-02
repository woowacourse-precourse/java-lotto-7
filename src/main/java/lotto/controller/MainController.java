package lotto.controller;

public class MainController {
    private static ViewControllerImpl viewController = ViewControllerImpl.getInstance();

    public static void run(){
        String money = viewController.getMoney();
    }
}
