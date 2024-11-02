package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.model.LottoGame;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void run(){
        int purchaseAmount=getPurchaseAmount();
        LottoGame lottoGame=new LottoGame(purchaseAmount);
        outputView.printLottoTickets(lottoGame.getLottoCount(),lottoGame.getLottoTickets());

        List<Integer>winningNumbers=getWinningNumbers();
        int bonusNumber=getBonusNumber(winningNumbers);



    }
    private int getPurchaseAmount(){
        while(true){
            try{
                int purchaseAmount=inputView.inputPurchaseAmount();
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            }
            catch (IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }
    private void validatePurchaseAmount(int purchaseAmount){
        if(purchaseAmount%1000!=0){
            throw new IllegalArgumentException("구입 금액이 1,000원 단위여야 합니다.");
        }
    }
    private List<Integer>getWinningNumbers(){
        while(true){
            try{
                String winningNumber=inputView.inputWinningNumbers();
                return validateWinningNumbers(winningNumber);
            }
            catch (IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<Integer> validateWinningNumbers(String winningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : winningNumber.split(",")) {
            String trimmedNumber = number.trim();
            validateNumber(trimmedNumber);
            int num = Integer.parseInt(trimmedNumber);
            checkDuplicate(winningNumbers, num);
            winningNumbers.add(num);
        }
        checkWinningNumbersCount(winningNumbers);

        return winningNumbers;
    }

    private void validateNumber(String number) {
        if (number.isEmpty() || !number.matches("\\d+")) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다: " + number);
        }
    }

    private void checkDuplicate(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("중복된 값이 입력되었습니다: " + number);
        }
    }

    private void checkWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }



    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = inputView.inputBonusNumber();
                validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
