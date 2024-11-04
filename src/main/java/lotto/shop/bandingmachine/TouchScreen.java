package lotto.shop.bandingmachine;

import java.util.List;
import lotto.MessageCenter;
import lotto.shop.Pos;
import lotto.user.UserStorage;

public class TouchScreen {

    TrialHistory trialHistory = new TrialHistory();
    DrawnNumbers drawnNumbers = DrawnNumbers.create();
    DrawSystem drawSystem = new DrawSystem(drawnNumbers);
    Pos pos = new Pos();
    Printer printer = new Printer();


    public void inputMoney() {
        MessageCenter.START.print();
        getMoney();
        getCount();
    }

    public void pushDraw() {
        Integer totalCount = trialHistory.getTotalCount();
        validatePaid();
        getDrawnNumbers(totalCount);
        UserStorage.saveNumbers(trialHistory.getDrawnNumberPacks());
        UserStorage.savePayment(trialHistory.getPayment());
        print();
    }

    public TrialHistory getTrialHistory() {
        return trialHistory;
    }

    private void print() {
        MessageCenter.NEW_LINE.print();
        System.out.println(trialHistory.getTotalCount() + MessageCenter.COUNT.get());
        printer.getPrintedPaper();
    }


    private void getDrawnNumbers(Integer totalCount){
        List<DrawnNumbers> drawnNumberPacks = drawSystem.runDraws(totalCount);
        trialHistory.saveDrawnNumberPacks(drawnNumberPacks);
    };

    private void getMoney() {
        Integer money = pos.checkMoney();
        trialHistory.savePayment(money);
    }

    private void getCount() {
        Integer payment = trialHistory.getPayment();
        Integer totalCount = pos.checkCount(payment);
        trialHistory.saveTotalCount(totalCount);
    }

    void validatePaid() {
        Integer payment = trialHistory.getPayment();
        if (payment == null || payment <= 0) {
            throw new IllegalArgumentException(MessageCenter.ERROR_PAYMENT.get());
        }
    }
}
