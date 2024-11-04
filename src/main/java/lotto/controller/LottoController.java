package lotto.controller;

import lotto.domain.*;
import lotto.view.ExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class LottoController {

    private static final int LOTTO_PRICE = 1000;
    private static List<Lotto> myLottos;
    private static Lotto winningNumbers;
    private static int bonusNumber;

    // 메인 실행 부
    public void start(){
        int purchaseAmount = lottoAmount();
        OutputView.printLottoAmount(purchaseAmount);
        myLottos = generateMyLottoList(purchaseAmount);
        OutputView.printMyLottoNumber(myLottos);

        WinningNumbers();
        bonusNumber();
        calculateLottoResult(purchaseAmount * LOTTO_PRICE);
    }
    // 로또 개수
    public int lottoAmount(){
        while (true) {
            try {
                String purchasePrice = InputView.inputPurchasePrice();
                LottoAmount lottoAmount = new LottoAmount(purchasePrice);
                return lottoAmount.getAmount();
            } catch (IllegalArgumentException e){
                // 예외 메시지는 이미 LottoAmount 클래스에서 출력됨
            }
        }
    }

    // 구매 금액만큼 내 로또 번호 생성
    public static List<Lotto> generateMyLottoList(int amount){
        myLottos = new ArrayList<>();
        RandomLottoNumbers lottoNumbers = new RandomLottoNumbers();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(lottoNumbers.generateRandomLottoNumbers());
            myLottos.add(lotto);
        }
        return myLottos;
    }

    // 입력 우승 번호 처리
    public static void WinningNumbers(){
        while(true){
            try{
                String inputWinningNumbers = InputView.inputWinningNumber();
                List<Integer> splitWinningNumbers = splitWinningNumbers(inputWinningNumbers);
                winningNumbers = new Lotto(splitWinningNumbers);
                break;
            } catch (IllegalArgumentException e){
                // 예외 메시지는 이미 splitWinningNumbers 메서드에서 출력됨
            }
        }

    }

    // 우승번호 입력값 나누기
    private static List<Integer> splitWinningNumbers (String inputWinningNumbers){
        String[] splitResult = inputWinningNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String string : splitResult) {
            numbers.add(convertToInt(string));
        }
        return numbers;
    }

    // 입력 번호 정수로 바꾸기
    private static int convertToInt(String inputNumber){
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            ExceptionMessage.priceNumberException();
            throw new IllegalArgumentException();
        }
    }

    // 보너스 번호 입력 및 유효 검사
    private static void bonusNumber(){
        while(true){
            try {
                int IntegerBonusNumber = convertToInt(InputView.inputBonusNumber());
                Lotto.validateBonusNumbers(winningNumbers.getNumbers(), IntegerBonusNumber);
                bonusNumber = IntegerBonusNumber;
                break;
            } catch (IllegalArgumentException e){
                // 예외 메시지는 이미 convertToInt 및 validateBonusNumbers 메서드에서 출력됨
            }
        }
    }

    private static void calculateLottoResult(int purchaseCost){
        LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber);
        for (Lotto lotto : myLottos) {
            LottoPrize prize = lottoResult.calculateResults(lotto);
            lottoResult.setResults(prize);
        }
        lottoResult.calculateTotalProfit(purchaseCost);
        lottoResult.printResults();
    }
}
