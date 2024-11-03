package lotto.shop.bandingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.MessageCenter;
import lotto.shop.Pos;
import lotto.user.UserStorage;

public class BandingMachine {

    TrialHistory trialHistory = new TrialHistory();
    DrawnNumbers drawnNumbers = DrawnNumbers.create();
    DrawSystem drawSystem = new DrawSystem(drawnNumbers);
    Pos pos = new Pos();
    List<String[]> paymentResult = new ArrayList<>();
    String resultMessage = "";

    public void inputMoney() {
        MessageCenter.START.print();
        getMoney();
        getCount();
        System.out.println(trialHistory.getTotalCount() + MessageCenter.COUNT.get());
    }

    public void drawNumbers(Integer totalCount) {
        getDrawnNumbers(totalCount);
        UserStorage.save(trialHistory.getDrawnNumberPacks());
        getPrintedPaper();
    }

    public TrialHistory getTrialHistory() {
        return trialHistory;
    }

    private void getPrintedPaper() {
        List<DrawnNumbers> drawnNumberPacks = UserStorage.get();
        List<String[]> printedFormat = getFormatted(drawnNumberPacks);
        getResultMessage(printedFormat);
    }

    private void getResultMessage(List<String[]> printedFormat) {
        for (String[] strings : printedFormat) {
            System.out.println(Arrays.toString(strings));
        }
    }

    private List<String[]> getFormatted(List<DrawnNumbers> drawnNumberPacks) {
        for (DrawnNumbers drawnNumberPack : drawnNumberPacks) {
            List<Integer> initialNumbers = getInitialNumbers(drawnNumberPack);
            List<String> mainNumbers = getPrintedFormat(initialNumbers);
            String[] printFormat = mainNumbers.toArray(new String[0]);
            paymentResult.add(printFormat);
        }
        return paymentResult;
    }

    private List<String> getPrintedFormat(List<Integer> initialNumbers) {
        List<String> printedFormat = null;
        int totalNumbers = initialNumbers.size();
        for (Integer initialNumber : initialNumbers) {
            String number = initialNumber.toString();
            printedFormat.add(number);
        }
        return printedFormat;
    }
    
    private List<Integer> getInitialNumbers(DrawnNumbers drawnNumberPack) {
        return drawnNumberPack.getMainNumbers();
    };

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
}
