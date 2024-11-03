package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static int purchasePrice;
    public static int lottoCount;
    public static Lotto winningNumber;
    public static int bonusNumber;
    public static Lotto[] lottos;
    public static int[] correctDetail = new int[5];
    public static int[] reward = {5000, 50000, 1500000, 30000000, 2000000000};

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 구입금액 입력을 요청하는 문자열 출력
        Print.pricePrint();

        // 구입 금액 입력 받아서 purchasePrice에 저장
        purchasePrice = Input.intInput();

        // 구앱 금액이 1,000원 단위로 입력되었는지 확인
        Error.isThousand(purchasePrice);

        // 로또 개수 저장
        lottoCount = purchasePrice/1000;

        // 구매 수량 출력
        Print.purchasePrint(lottoCount);

        // 구매한 로또 번호가 저장된 배열 초기화
        lottos = new Lotto[lottoCount];

        // 랜덤 번호를 이용한 로또 번호 저장
        for (int i=0;i<lottoCount;i++) {
            lottos[i] = Lotto.randomLotto();
        }

        // 로또 목록 출력
        for (int i=0;i<lottoCount;i++) {
            Print.lottoPrint(lottos[i]);
        }

        // 당첨 번호 입력을 요청하는 문자열 출력
        Print.numberPrint();

        // 당첨 번호를 입력받아서 리스트에 저장
        String[] inputNumber = Input.stringInput().split(",");
        List<Integer> temporaryNumber = new ArrayList<>();
        for (int i = 0; i< inputNumber.length; i++) {
            temporaryNumber.add(Integer.parseInt(inputNumber[i]));
        }
        Error.duplicates(temporaryNumber);

        // 로또 클래스로 당첨 번호 저장
        winningNumber = new Lotto(temporaryNumber);

        // 보너스 번호 입력을 요청하는 문자열 출력
        Print.bonusPrint();

        // 보너스 번호를 입력받아서 저장
        bonusNumber = Input.intInput();

        // 당첨 통계 문구 출력
        Print.winPrint();

        // 당첨 개수 저장할 배열 초기화
        correctDetail = new int[5];

        // 당첨 결과 판단
        Correct.iterator();

        // 당첨 결과 출력
        Print.correct3();
        Print.correct4();
        Print.correct5();
        Print.correctBonus();
        Print.correct6();

        // 총 수익률 출력
        Print.totalReward((Correct.profit()/purchasePrice)*100.0);
    }
}
