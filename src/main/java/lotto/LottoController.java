package lotto;


import static lotto.View.InputView.inputPlayerMoney;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import lotto.Model.Lotto;
import lotto.Model.RandomNumberCreate;
import lotto.Model.WinningResult;
import lotto.Model.Ranking;
import lotto.View.ExceptionMessage;
import lotto.View.OutputView;
import lotto.View.InputView;
import java.util.Map;

public class LottoController {
    //private final int ticketPrice =1000; //티켓 가격
    private static final int PERCENTAGE = 100;
    private static final int TICKET_PRICE = 1000;

    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningResult winningResult;

    LottoController(){
        //생성자
    }

    public void run(){
        try{
            start();
        } catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
/*
    public void start(){
        try {
            int ticketCount = Integer.parseInt(inputPlayerMoney()) / TICKET_PRICE;
        }catch(NumberFormatException e) {//갖고 있던 돈으로 산 티켓 수
            ExceptionMessage.typeException();
            start();
        }
        OutputView.printTicketCount(ticketCount); // 개수 카운트

        lottoList = makeLottoList(ticketCount); // 랜덤 번호 생성 후 랜덤로또번호 출력
        winningResult =validateBonus(); //

        lottoResult(lottoList, winningResult, ticketCount);

    }
*/
    public void start() {
        int ticketCount = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                int playerMoney = Integer.parseInt(InputView.inputPlayerMoney());
                ticketCount = playerMoney / TICKET_PRICE;
                validInput = true; // 유효한 입력이 들어온 경우 반복 종료
            } catch (NumberFormatException e) {
                ExceptionMessage.typeException(); // "[ERROR] 숫자만 입력해 주세요."
            }
        }

        OutputView.printTicketCount(ticketCount); // 티켓 수 출력

        lottoList = makeLottoList(ticketCount); // 랜덤 번호 생성 후 로또 번호 출력
        winningResult = validateBonus(); // 보너스 번호 유효성 검사

        lottoResult(lottoList, winningResult, ticketCount); // 결과 출력
    }



    private static Lotto makeLotto() {
        RandomNumberCreate lottoNumbers = new RandomNumberCreate();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    public static WinningResult validateBonus() {
        Lotto lotto= new Lotto(InputView.inputWinningNumber());
        List<Integer> winningNumber= lotto.getLottoNumbers();

        int ball =InputView.inputBonusNumber();
        lotto.validateBonusNumber(winningNumber,ball);
        winningResult = new WinningResult(new Lotto(winningNumber),ball);
        return winningResult;
    }

    private void lottoResult(List<Lotto> lottoList, WinningResult winningLotto, int amount) {
        Map<Ranking, Integer> result = setResult();
        Ranking rank;

        OutputView.printSuccessResult();
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }

    private void printResult(Map<Ranking, Integer> result) {
        for (int i = Ranking.values().length - 1; i >= 0; i--) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }

    private void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Ranking rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getWinningAmount()) / (lottoAmount * TICKET_PRICE) * (result.get(
                            rank)) * (PERCENTAGE));

        }
        OutputView.printRevenueRate(EarningRate);
    }


    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}
