package lotto;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력기능
        int inputMoney = Money.inputMoney();
        // 발행한 로또 수량을 출력
        int numberOfLotto = inputMoney / 1000;
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");
        // 로또 발행 기능
        BuyLotto lottoList = new BuyLotto(numberOfLotto);
        lottoList.printLottoList();

    }
}
