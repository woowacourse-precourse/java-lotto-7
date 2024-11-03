package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    public void outputNumberOfLotto(int numberOfLotto){
        System.out.println("\n"+numberOfLotto+"개를 구매했습니다.");
    }

    public void outputLottos(List<Lotto> lottoTickets){
        for (Lotto lottoTicket : lottoTickets) {
            List<Integer> numbers = lottoTicket.getNumbers();
            System.out.println(numbers);
        }
    }

    public void outputStatistics(){

    }
}
