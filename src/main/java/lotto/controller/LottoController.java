package lotto.controller;

import lotto.Lotto;
import lotto.message.Message;
import lotto.view.LottoView;

import java.util.*;

public class LottoController {

    private final Integer LOTTO_PRICE = 1000;

    public void run(){
        String inputAmount = LottoView.inputAmount();
        List <Lotto> lottoList= purchaseLotto(Integer.parseInt(inputAmount) / LOTTO_PRICE);
        LottoView.printLottoList(lottoList);
        String inputWinningNumber = LottoView.inputWinningNumbers();
        List<Integer> winningNumbers = convertToIntegerList(inputWinningNumber);
        String bonusNumber = LottoView.inputBonusNumbers();

    }

    private List<Lotto> purchaseLotto(Integer amount){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i =0; i< amount; i++){
            lottoList.add(new Lotto(Lotto.createLotto()));
        }
        return lottoList;
    }

    private List<String> parseWinningNumbers(String winningNumbers){
        String delimiter = ",";
        String [] numbers = winningNumbers.split(delimiter);

        return Arrays.asList(numbers);
    }

    private Integer parseStringToInt(String winningNumbers){
        try{
            Integer number = Integer.parseInt(winningNumbers);
            return number;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(Message.ILLEGAL_ARGUMENT_ERROR.toString());
        }
    }

    private List<Integer> convertToIntegerList(String winningNumbers) {
        List<String> stringNumbers = parseWinningNumbers(winningNumbers);
        List<Integer> integerNumbers = new ArrayList<>();

        for (String number : stringNumbers) {
            integerNumbers.add(parseStringToInt(number));
        }

        return integerNumbers;
    }
}
