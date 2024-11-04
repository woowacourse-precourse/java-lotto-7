package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Handler;
import lotto.view.Input;
import lotto.view.Print;

/**
 *  1. 애플리케이션 실행시 사용자가 구매 금액을 입력하면
*    2. 구매 결과를 기반으로 로또 발행 기능을 실행하고 발행한 로또를 조회하여 출력
*    3. 그 다음 사용자가 당첨 번호를 입력하고
*    4. 보너스 번호까지 입력하면
*    5. 내부적으로 구매 금액만큼의 로또를 발행하여 당첨 번호와 보너스 번호를 적절히 비교 하고
*    6. 비교한 결과를 토대로 총 수익률 계산
*    7. 당첨 번호 / 보너스 번호 비교 결과를 조회하여 각각 당첨 통계와 수익률을 출력하고 애플리케이션 종료
*    8. 사용자가 잘못된 값을 입력할 경우 예외 처리
*       1. 예외 발생 원인을 명확히 전달하는 유형 사용
*       2. 예1) 입력 가능 범위를 초과한 경우 IllegalArgumentException 예외 처리하며 로또 구매 가능 금액 문구를 출력하고 정상 문구 재입력을 요청
*       3. 예2) 문자열이 포함된 값을 입력한 경우 NumberFormatException 예외 처리로 에러 메시지를 출력하고 정상 값 재입력을 요청
 */
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

//        1. 애플리케이션 실행시 사용자가 구매 금액을 입력하면

        Input input = new Input(Console.readLine());
        int amount = input.readAmount();
//        2. 구매 결과를 기반으로 로또 발행 기능을 실행하고 발행한 로또를 조회하여 출력
        int request = input.getLottoCounts(amount);
        Handler handler = new Handler(request);
        List<Integer> generated = handler.generateLotto();
        Lotto lotto = new Lotto(generated);
        List<List<Integer>> findByLotto = lotto.responseLottoCounts(request);
        Print print = new Print(handler, input, lotto);
        print.printGenerated(findByLotto);
//          3. 그 다음 사용자가 당첨 번호를 입력하고
        String winningNumbers = input.readWinning();
        List<Integer> getWinning = handler.getWinning(winningNumbers);
//          4. 보너스 번호까지 입력하면
        int bonus = input.readBonus();
//          5. 내부적으로 구매 금액만큼의 로또를 발행하여 당첨 번호와 보너스 번호를 적절히 비교 하고
        String comparedResult = handler.compareNumbersResult(findByLotto, getWinning, bonus);
//          6. 비교한 결과를 토대로 총 수익률 계산
        double revenue = handler.valueationRevenue(comparedResult, amount);
        String metric = handler.getResult(revenue);
//         7. 당첨 번호 / 보너스 번호 비교 결과를 조회하여 각각 당첨 통계와 수익률을 출력하고 애플리케이션 종료
        print.printMetric(metric, amount);
    }
}
