package lotto;

import lotto.exception.ErrorCode;

public class PurchaseAmount {

    private final int money;
    private final int ticket;

    private static final int ticketPrice = 1000;

    public PurchaseAmount(final String money){
        validate(money);
        this.money = Integer.valueOf(money);
        this.ticket = this.money / ticketPrice;
    }
    private void validate(final String money){

        try {
            int parsedMoney = Integer.parseInt(money);
            checkMoneyOverZero(parsedMoney);
            checkMoneyDivideBy1000(parsedMoney);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.CANT_CONVERT_TO_INTEGER.getMessage());
        }

    }

    private void checkMoneyOverZero(final int parsedMoney){

        if (parsedMoney <= 0) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_MUST_BE_OVER_ZERO.getMessage());
        }
    }

    private void checkMoneyDivideBy1000(final int parsedMoney){

        if (parsedMoney % 1000 != 0){
            throw new IllegalArgumentException(ErrorCode.CANT_PURCHASE_AMOUNT_DIVIDE_BY_1000.getMessage());
        }
    }

    public int getMoney(){
        return this.money;
    }

    public int getTicket(){
        return this.ticket;
    }




}
