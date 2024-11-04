package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoMachine lottoMachine = new LottoMachine(Console.readLine());
        lottoMachine.makeLottos();
        lottoMachine.printLottos();
        lottoMachine.inputWinnigNumbers(Console.readLine());
        lottoMachine.inputBonusNumbers(Console.readLine());
        lottoMachine.initPrizeMap();
        lottoMachine.makePrizeMap();
        lottoMachine.printPrize();
        lottoMachine.printProfit();
    }
}
