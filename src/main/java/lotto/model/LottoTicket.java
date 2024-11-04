package lotto.model;

import lotto.validator.AmountValidator;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<Lotto> lotteries;
    private final int purchase;

    private LottoTicket(List<Lotto> lotteries, int purchase) {
        this.lotteries =lotteries;
        this.purchase = purchase;
    }

    public static LottoTicket create(String input, LottoMachine lottoMachine, AmountValidator amountValidator){
        int purchaseAmount = validateAmount(input,amountValidator);
        int quantity = calculateQuantity(purchaseAmount);
        List<Lotto> lotteries = generateLotteries(quantity,lottoMachine);
        return new LottoTicket(lotteries, purchaseAmount);
    }

    private static int validateAmount(String input, AmountValidator amountValidator){
        amountValidator.validate(input);
        return Integer.parseInt(input);
    }

    private static int calculateQuantity(int amount){
        return amount / 1000;
    }

    private static List<Lotto> generateLotteries(int quantity, LottoMachine lottoMachine){
        List<Lotto> lotteries = new ArrayList<>();
        for(int i = 0; i < quantity; i++){
            lotteries.add(lottoMachine.generate());
        }
        return  lotteries;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int getPurchase() {
        return purchase;
    }
}
