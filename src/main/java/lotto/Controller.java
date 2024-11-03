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
        while (true) {
            try {
                service.inputAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputSelectedNumbers() {
        while (true) {
            try {
                service.inputSelectedNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
        while (true) {
            try {
                service.inputBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
