package lotto.view;

public class OutputView {
    private OutputView() {
    }

    private static class SingletonHelper {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputView.SingletonHelper.INSTANCE;
    }


    public void showDescription() {
        System.out.println(description);
    }

    public void outputLottos(String lottosString) {
        System.out.println(lottosString);
    }

    public void outputResult(String resultString) {
        System.out.println("당첨 통계\n---");
        System.out.println(resultString);
    }


    String description = """
            ================================================================
                                       로또 설명서
            
            간단한 로또 발매기 프로그램입니다. 로또 구입 금액과 당첨 번호, 보너스 번호
            를 입력하면 당첨 결과를 계산해서 당첨 통계를 출력해줍니다.
            
            사용 방법
            1. 로또 구입 금액을 입력합니다. 로또 구입 금액은 1,000 이상 100,000 이하의
               정수여야 하고, 1,000으로 나누어 떨어져야 합니다. 로또 한 장의 금액은
               1,000원입니다. (8000 입력 시 8장 구입)
               로또 구입 금액 입력을 마치면 로또가 발행되고, 발행된 로또들이 출력됩니다.
            
            2. 다음으로 당첨 번호를 입력합니다. 당첨 번호는 1부터 45까지의 6개의 정수여야
               하고, ','을 기준으로 구분되어야 합니다. 이 때, 당첨 번호를 중복으로 입력할
               수 없고, 입력에 공백이 포함되면 안됩니다.
               1,2,3,4,5,6 (o)   1,2,3,4,5,5 (x)  1, 2, 3, 4, 5, 6 (x)
            
            3. 마지막으로 보너스 번호를 입력합니다. 보너스 번호는 1부터 45까지의 정수여야
               하고, 앞에서 입력한 당첨 번호와 중복될 수 없습니다.
               보너스 번호 입력을 마치면 구입한 로또의 당첨 통계가 출력됩니다.
            
            =================================================================
            """;
}
