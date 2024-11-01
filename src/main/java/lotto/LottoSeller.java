package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoSeller {
    private int cash;
    private int lottoNumber = 0;

    public void initLottoNumber(){
        System.out.println(Message.GET_INPUT_MESSAGE.getMessage());
        cashValidate(getInput());
    }

    private static String getInput(){
        return Console.readLine();
    }

    protected void cashValidate(String input){
        isNumber(input);
        isDivisibleByThousand();
    }

    protected void isNumber(String input){
        if(input == null || input.isBlank() || input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getErrorMessage());
        }
        if(!input.matches("[\\d]+")){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_POSITIVE_NUMBER.getErrorMessage());
        }
        cash = Integer.parseInt(input);
    }

    protected void isDivisibleByThousand(){
        final int LOTTO_PRICE = 1000;
        if(cash == 0 || cash % LOTTO_PRICE > 0 ){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_DIVISIBLE_BY_THOUSAND.getErrorMessage());
        }
        lottoNumber = (cash / LOTTO_PRICE);
    }

    protected int getLottoNumber(){
        return lottoNumber;
    }

}
