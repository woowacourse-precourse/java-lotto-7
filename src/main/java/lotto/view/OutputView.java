package lotto.view;

public class OutputView implements UserOutput{
    @Override
    public void outputLottoCount(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다."));
    }

    @Override
    public void outputStatistics() {

    }
}
