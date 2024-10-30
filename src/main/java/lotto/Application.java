package lotto;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine(6);

        System.out.println(lottoMachine.getLottoNumbers());
    }
}
