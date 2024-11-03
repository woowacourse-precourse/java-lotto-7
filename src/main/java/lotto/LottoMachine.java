package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


/**
 * 1. 구입 금액 입력받기
 * 2. 로또 구매
 * 3. 당첨번호 & 보너스 번호 입력받기
 * 4. 당첨 통계 계산(별도 클래스) 결과 출력
 */
public class LottoMachine {
    public static final Integer START_INCLUSIVE = 1;
    public static final Integer END_INCLUSIVE = 45;
    public static final Integer LOTTO_SIZE = 6;
    private final Verifier verifier = new Verifier();
    private LotteryDevice lotteryDevice;
    private final ArrayList<Lotto> purchasedLottoTickets = new ArrayList<>();
    private ArrayList<Integer> winningNumbers = new ArrayList<>();
    private int plusNumber;


    public void run() {
        buyLotto();
        printLottoNumbers();
        makeWinningLottoInfo();
        lotteryDevice = new LotteryDevice(purchasedLottoTickets, winningNumbers, plusNumber);
        lotteryDevice.run(); // 상품 집계 및 통계 결과 출력
    }

    public void makeWinningLottoInfo() {
        winningNumbers = getInputWinningNumbers();
        plusNumber = getInputPlusNumber();
    }

    public int getInputPlusNumber() {
        System.out.println();
        String inputData;
        do {
            System.out.println("보너스 번호를 입력해 주세요.");
            inputData = Console.readLine();
        } while (!verifier.isValidPlusNumber(inputData));
        return Integer.parseInt(inputData);
    }

    public ArrayList<Integer> getInputWinningNumbers() {
        System.out.println();
        String inputData;
        do {
            System.out.println("당첨 번호를 입력해 주세요.");
            inputData = Console.readLine();
        } while (!verifier.isValidWinningNumbers(inputData));
        return new ArrayList<>(verifier.getLottoNumbers());
    }

    public void buyLotto() {
        int purchaseAmount = getInputPurchaseAmount();
        int purchaseQuantity = amountToQuantity(purchaseAmount);
        // 로또 구입
        for (int i = 0; i < purchaseQuantity; i++) {
            purchasedLottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_SIZE)));
        }
    }

    public void printLottoNumbers() {
        System.out.println();
        System.out.println(purchasedLottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottoTickets) {
            lotto.printLottoNumbers();
        }
    }

    public int amountToQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public int getInputPurchaseAmount() {
        String input;
        do {
            System.out.println("구입금액을 입력해 주세요.");
            input = Console.readLine();
        } while (!verifier.isValidPurchaseAmount(input)); // 올바른 값을 입력받을 때 까지 반복
        return Integer.parseInt(input);
    }
}
