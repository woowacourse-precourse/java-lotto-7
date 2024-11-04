package lotto.simulation;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.io.ConsoleInputHandler;
import lotto.io.ConsoleOutputHandler;
import lotto.model.*;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulator {
    public void run() {
        BuyAmount buyAmount = getBuyAmount(); // 구매 금액을 입력받음
        int lottoAmount = buyAmount.lottoAmount(); // 구입한 로또 개수
        ConsoleOutputHandler.lottoAmountMessage(lottoAmount); // 구입한 로또 개수 출력
        List<Lotto> lottoList = createLotto(lottoAmount); // 구매한 로또 개수 만큼 로또 번호 발행
        WinningNumber winningNumber = getWinningNumber(); // 당첨 번호를 입력받음
        BonusNumber bonusNumber = getBonusNumber(winningNumber); // 보너스 번호를 입력받음
        Game game = new Game(lottoList,winningNumber,bonusNumber); // 당첨 정보를 가진 게임 객체 생성
        ConsoleOutputHandler.gameResultMessage(); // 당첨 통계 안내 메세지 출력
        game.outReturnRate(); // 수익률 출력
    }

    private List<Lotto> createLotto(int lottoAmount) {
        List<Lotto> lottoList = new ArrayList<>(); // 로또 리스트 생성
        for(int i = 0; i < lottoAmount; i++){ // 구입한 개수 만큼 로또 생성
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)); // 고유한 1 - 45 내에서 로또 생성
            lottoList.add(lotto); // 로또 리스트에 로또 추가
            lotto.lottoNumberOut(); // 로또 번호 출력
        }
        return lottoList;
    }

    private BonusNumber getBonusNumber(WinningNumber winningNumber) {
        while(true){
            try{
                ConsoleOutputHandler.bounsNumberMessage(); // 보너스 번호 입력 안내 메세지 출력
                String bounsNumberString = ConsoleInputHandler.input(); // 보너스 번호 문자열로 입력받음
                return new BonusNumber(bounsNumberString, winningNumber);
            } catch(IllegalArgumentException e){
                ConsoleOutputHandler.exceptionMessage(e);
            }
        }

    }

    private WinningNumber getWinningNumber() {
        while(true){
            try{
                ConsoleOutputHandler.winningNumberMessage(); // 당첨 번호 입력 안내 메세지 출력
                String winningNumberString = ConsoleInputHandler.input(); // 당첨 번호 문자열로 입력받음
                return new WinningNumber(winningNumberString);
            } catch(IllegalArgumentException e){
                ConsoleOutputHandler.exceptionMessage(e);
            }
        }
        
    }

    private BuyAmount getBuyAmount() {
        while(true){
            try{
                ConsoleOutputHandler.buyAmountMessage(); // 구입 금액 안내 메세지 출력
                String buyAmountString = ConsoleInputHandler.input(); // 구입 금액 문자열로 입력받음
                return new BuyAmount(buyAmountString);
            } catch(IllegalArgumentException e){
                ConsoleOutputHandler.exceptionMessage(e);
            }
        }
    }
}
