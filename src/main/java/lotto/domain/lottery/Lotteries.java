package lotto.domain.lottery;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.vo.WinningNumberMatchCountVO;

public class Lotteries {
    private final List<Lottery> lotteries;

    private Lotteries(List<Lottery> lotteries) {
        this.lotteries = List.copyOf(lotteries);
    }

    public static Lotteries newInstance(List<Lottery> lotteries){
        return new Lotteries(lotteries);
    }

    public List<Lottery> getLottery() {
        return new ArrayList<>(lotteries);
    }

    public List<WinningNumberMatchCountVO> WinningNumberMatchCount(List<Integer> winningNumbers){
        List<WinningNumberMatchCountVO> winningNumberMatchCountVOS = new ArrayList<>();
        for (Lottery lottery :lotteries) {
            Integer counted = lottery.countMatchingWinningNumbers(winningNumbers);
            winningNumberMatchCountVOS.add(new WinningNumberMatchCountVO(lottery,counted));
        }
        return winningNumberMatchCountVOS;
    }
}
