package lotto;

import java.util.List;
import java.util.Set;

public class Application {

    static int purchaseAmount;
    static Set<Integer> lottoWinningNumbers;
    static int bonusNumber;
    static List<Lotto> purchaseLottos;

    static Input input=new Input();
    static RandomNumAllocation randomNumAllocation;
    static Output output=new Output();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true) {
            try {
                inputPurchaseAmount();
                randomLottoAllocation();
                printPurchaseLottoNum();
                winningNumberInput();

                break;
            } catch (NumberFormatException e) {
                System.err.println(("[ERROR] 숫자만 입력할수있습니다."));
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());

            }
        }
    }

    public static void inputPurchaseAmount() {

        //Console input
        input.setPurchaseAmount();
        purchaseAmount = input.getPurchaseAmount();

    }

    public static void randomLottoAllocation() {

        randomNumAllocation=new RandomNumAllocation(purchaseAmount);
        purchaseLottos=randomNumAllocation.getPurchasedLottos();
        output.setPurchasedLottos(purchaseLottos);
        output.setPurchasedAmount(purchaseAmount);

    }

    public static void printPurchaseLottoNum() {
        output.setPurchasedLottos(purchaseLottos);
        output.printPurchasedLottos();
    }

    public static void winningNumberInput(){
        input.setLottoWinningNumbers();
        input.setBonusNumber();
    }


}
