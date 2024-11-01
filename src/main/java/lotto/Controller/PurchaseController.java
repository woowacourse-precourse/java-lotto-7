package lotto.Controller;

import lotto.Lotto;
import lotto.Service.PurchaseService;
import lotto.View.PurchaseView;
import lotto.Pair;

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
                validate = validated.getBoolean();
                count = (Integer)validated.getValue();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        List<Lotto> lottos = purchaseService.draw(count);
        purchaseView.output(count, lottos);
        return lottos;
    }

    private Pair purchaseFlow() {
        String inputed = purchaseView.input();
        return purchaseFlowWithInput(inputed);
    }

    public Pair purchaseFlowWithInput(String inputed) {
        Pair result = new Pair();
        if(!Validate.isInteger(inputed))
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");

        int count = purchaseService.buy(Integer.parseInt(inputed));
        if (count > 0) {
            result.set(true, count);
            return result;
        }
        result.set(false, 0);
        return result;
    }
}