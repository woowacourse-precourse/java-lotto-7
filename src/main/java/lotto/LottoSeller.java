package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private int cash;
    private int lottoNumber = 0;
    private List<Lotto> customerLottos = new ArrayList<Lotto>();

    public void initLottoNumber(){
        System.out.println(Message.GET_INPUT_MESSAGE.getMessage());
        cashValidate(getInput());
        buyLotto();
        System.out.println(printLotto());
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
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getMessage());
        }
        if(!input.matches("[\\d]+")){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_POSITIVE_NUMBER.getMessage());
        }
        cash = Integer.parseInt(input);
    }

    protected void isDivisibleByThousand(){
        final int LOTTO_PRICE = 1000;
        if(cash == 0 || cash % LOTTO_PRICE > 0 ){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
        lottoNumber = (cash / LOTTO_PRICE);
    }

    protected void buyLotto(){
        List<Integer> customerLotto;
        for(int i=0; i< lottoNumber; i++){
            customerLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            customerLottos.add(new Lotto(customerLotto));
        }
    }

    protected String printLotto(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottoNumber + Message.GET_LOTTO_MESSAGE.getMessage());
        for(Lotto curlotto: customerLottos){
            stringBuilder.append(curlotto.getLottoNumber());
        }
        return stringBuilder.toString();
    }

    protected int getLottoNumber(){
        return lottoNumber;
    }

}
