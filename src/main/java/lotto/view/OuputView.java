package lotto.view;

import java.util.List;
import lotto.model.Quantity;

public class OuputView {
    public static final String QUANTITY_RESULT = "%d개를 구매했습니다.";

    private static OuputView instance;

    private OuputView() {
    }

    public static OuputView getInstance() {
        if (instance == null) {
            instance = new OuputView();
        }
        return instance;
    }

    public void printQuantityResult(int quantity) {
        System.out.printf(QUANTITY_RESULT, quantity);
        System.out.println();
    }

    public void printLottoDrawResult(List<String> numbers) {
        for (String number : numbers) {
            System.out.println(number);
        }
    }

}
