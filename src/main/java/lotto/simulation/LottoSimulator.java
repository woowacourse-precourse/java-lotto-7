package lotto.simulation;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.io.ConsoleInputHandler;
import lotto.io.ConsoleOutputHandler;
import lotto.model.BonusNumber;
import lotto.model.BuyAmount;
import lotto.model.Lotto;
import lotto.model.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulator {
    public void run() {
        ConsoleOutputHandler.buyAmountMessage(); // 구입 금액 안내 메세지 출력
        String buyAmountString = ConsoleInputHandler.input(); // 구입 금액 문자열로 입력받음
        BuyAmount buyAmount = new BuyAmount(buyAmountString); // 구입 금액 객체 생성 (혹은 에러 반환)

        int lottoAmount = buyAmount.lottoAmount(); // 구입한 로또 개수
        ConsoleOutputHandler.lottoAmountMessage(lottoAmount); // 구입한 로또 개수 출력

        List<Lotto> lottoList = new ArrayList<>(); // 로또 리스트 생성
        for(int i = 0; i < lottoAmount; i++){ // 구입한 개수 만큼 로또 생성
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)); // 고유한 1 - 45 내에서 로또 생성
            lottoList.add(lotto); // 로또 리스트에 로또 추가
            lotto.lottoNumberOut(); // 로또 번호 출력
        }

        ConsoleOutputHandler.winningNumberMessage(); // 당첨 번호 입력 안내 메세지 출력
        String winningNumberString = ConsoleInputHandler.input(); // 당첨 번호 문자열로 입력받음
        WinningNumber winningNumber = new WinningNumber(winningNumberString); // 당첨 번호 객체 생성 (혹은 에러 반환)

        ConsoleOutputHandler.bounsNumberMessage(); // 보너스 번호 입력 안내 메세지 출력
        String bounsNumberString = ConsoleInputHandler.input(); // 보너스 번호 문자열로 입력받음
        BonusNumber bonusNumber = new BonusNumber(bounsNumberString, winningNumber); // 보너스 번호 객체 생성 (혹은 에러 반환)
    }
}
