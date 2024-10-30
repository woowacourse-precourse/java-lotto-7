package lotto.Controller;

import lotto.Service.PurchaseService;
import lotto.View.PurchaseView;
import org.assertj.core.groups.Tuple;

import java.util.HashMap;
import java.util.Map;

public class PurchaseController {
    private PurchaseView purchaseView;
    private PurchaseService purchaseService;

    public PurchaseController() {
        purchaseView = new PurchaseView();
        purchaseService = new PurchaseService();
    }

    public int purchase() {
        boolean validate = false;
        int count = 0;
        while(!validate) {
            try {
                validate = purchaseFlow().isValidated();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        purchaseView.output(count);
        return count;
    }

    private Pair purchaseFlow() {
        Pair result = new Pair();
        int count = purchaseService.buy(purchaseView.input());
        if (count > 0) {
            result.set(true, count);
            return result;
        }
        result.set(false, 0);
        return result;
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
