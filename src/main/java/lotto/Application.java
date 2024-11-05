package lotto;

import lotto.manager.OperationManager;

public class Application {
    public static void main(String[] args) {
        OperationManager operationManager = new OperationManager();
        operationManager.execute();
    }
}
