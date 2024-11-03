package lotto;

public class Controller {

    private final Service service = new Service();

    public void run() {
        inputPurchaseAmount();
        service.showLottos();
        inputSelectedNumbers();
        inputBonusNumber();
        service.operateLottos();
        service.OutputResult();
    }

    private void inputPurchaseAmount() {
        boolean isOk = false;
        while (!isOk) {
            try {
                isOk = service.inputAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputSelectedNumbers() {
        boolean isOk = false;
        while (!isOk) {
            try {
                isOk = service.inputSelectedNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
        boolean isOk = false;
        while (!isOk) {
            try {
                isOk = service.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
