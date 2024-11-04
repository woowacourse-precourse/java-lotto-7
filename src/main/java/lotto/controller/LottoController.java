package lotto.controller;

import static lotto.view.input.readBonusNumber;
import static lotto.view.input.readTotalAmount;
import static lotto.view.input.readWinningNumbers;

import java.util.ArrayList;
import java.util.List;
import lotto.model.CalculateResult;
import lotto.model.Lotto;
import lotto.Constants.ErrorMessages;
import lotto.model.WinningLotto;

public class LottoController {
    private int totalCount;
    private List<Lotto> lottos;

    public LottoController() {
        this.totalCount = 0;
        this.lottos = new ArrayList<>();
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static int getValidInputTotalAmount() {
        String input = readTotalAmount();
        int result;
        while (true) {
            try {
                result = Integer.parseInt(input);
                return result;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.NUMBER_FORMAT_ERROR.getMessage());
                input = readTotalAmount();
            }
        }
    }

    public static int checkTotalAmountIfValid(int totalAmount) {
        if (totalAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_TOTAL_AMOUNT_ERROR.getMessage());
        }
        return totalAmount / 1000;
    }

    public void setTotalCount(){
        int totalCount;
        while(true){
            totalCount = getValidInputTotalAmount();
            try{
                totalCount = checkTotalAmountIfValid(totalCount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        this.totalCount = totalCount;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private void inputNullCheck(String s){
        if (s.isEmpty()){
            throw new IllegalArgumentException(ErrorMessages.NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    public List<Integer> changeStringListToIntList(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        for (String s : stringList){
            inputNullCheck(s);
            intList.add(Integer.valueOf(s));
        }
        return intList;
    }

    public WinningLotto makeWinningLotto() {
        List<String> inputNumbers = readWinningNumbers();
        while(true){
            try {
                List<Integer> numbers = changeStringListToIntList(inputNumbers);
                Lotto lotto = new Lotto(numbers);
                return new WinningLotto(lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputNumbers = readWinningNumbers();
            }
        }
    }

    public void bonusNumber(WinningLotto winningLotto){
        String bonusNumber;
        while(true){
            bonusNumber = readBonusNumber();
            try{
                inputNullCheck(bonusNumber);
                winningLotto.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void getSummary(LottoController lottoController, WinningLotto winningLotto) {
        CalculateResult calculator = new CalculateResult(winningLotto);
        calculator.calculateMatches(lottoController.getLottos());
        calculator.getTotalResult(lottoController.totalCount);
    }
}
