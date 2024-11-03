package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Integer money = inputMoney();
        List<Lotto> lottos = Lotto.start(money);
        List <Integer> winNumbers = inputWinNumbers();
        Integer bonusNumber = inputBonusNumber(winNumbers);

        LottoService lottoService = new LottoService();
        LottoStatistics statistics = lottoService.calculateStatistics(lottos, winNumbers, bonusNumber);

        Print.printStatistics(statistics.getStatistics());
    }


    private static Integer inputMoney() {
        while (true) {
            try {
                return Input.inputMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> inputWinNumbers() {
        while (true) {
            try {
                return Input.inputWinNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Integer inputBonusNumber(List<Integer> winNumbers) {
        while (true) {
            try {
                return Input.inputBonusNumber(winNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
