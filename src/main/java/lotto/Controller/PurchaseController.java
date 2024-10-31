package lotto.Controller;

import lotto.Lotto;
import lotto.Service.PurchaseService;
import lotto.View.PurchaseView;

import java.util.List;

public class PurchaseController {
    private PurchaseView purchaseView;
    private PurchaseService purchaseService;

    public PurchaseController() {
        purchaseView = new PurchaseView();
        purchaseService = new PurchaseService();
    }

    public List<Lotto> purchase() {
        boolean validate = false;
        int count = 0;
        while(!validate) {
            try {
                Pair validated = purchaseFlow();
                validate = validated.isValidated();
                count = validated.getCount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        List<Lotto> lottos = purchaseService.draw(count);
        purchaseView.output(count, lottos);
        return lottos;
    }

    private Pair purchaseFlow() {
        Pair result = new Pair();
        String inputed = purchaseView.input();
        if(!isInteger(inputed))
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");

        int count = purchaseService.buy(Integer.parseInt(inputed));
        if (count > 0) {
            result.set(true, count);
            return result;
        }
        result.set(false, 0);
        return result;
    }

    private boolean isInteger(String s) {
        return s.matches(".?\\d+");
    }
}

class Pair {
    private boolean validated;
    private int count;

    public Pair() {}

    public Pair(boolean validated, int count) {
        this.validated = validated;
        this.count = count;
    }

    public void set(boolean validated, int count) {
        this.validated = validated;
        this.count = count;
    }

    public boolean isValidated() { return validated; }
    public int getCount() { return count; }
}
