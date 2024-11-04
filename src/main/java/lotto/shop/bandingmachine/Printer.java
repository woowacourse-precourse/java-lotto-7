package lotto.shop.bandingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.MessageCenter;
import lotto.user.UserStorage;

public class Printer {

    List<String[]> paymentResult = new ArrayList<>();

    void getPrintedPaper() {
        validateUserStorage();
        List<DrawnNumbers> drawnNumberPacks = UserStorage.getNumbers();
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
        List<String> printedFormat = new ArrayList<>();
        for (Integer initialNumber : initialNumbers) {
            String number = initialNumber.toString();
            printedFormat.add(number);
        }
        return printedFormat;
    }

    private List<Integer> getInitialNumbers(DrawnNumbers drawnNumberPack) {
        return drawnNumberPack.getMainNumbers();
    };


    private void validateUserStorage() {
        List<DrawnNumbers> drawnNumberPacks = UserStorage.getNumbers();
        if (drawnNumberPacks == null || drawnNumberPacks.isEmpty()) {
            throw new IllegalArgumentException(MessageCenter.ERROR_USERSTORAGE.get());
        }
    }

}
