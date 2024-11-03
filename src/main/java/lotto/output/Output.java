package lotto.output;

import lotto.LottoPrize;

import java.util.List;
import java.util.Map;

public class Output {

    public void write(String string) {
        System.out.println(string);
    }

    public void write(String format, Double number) {
        String output = String.format(format, number);
        write(output);
    }

    public void write(String format, Object... objects) {
        String output = String.format(format, objects);
        write(output);
    }

    public void write(String format, Integer number) {
        String output = String.format(format, number);
        write(output);
    }

    public void writeLottoPrize(Map<LottoPrize, Integer> map, Double roi) {
        write("당첨 통계");
        write("---");
        map.forEach(this::writeDetailResult);
        write("총 수익률 %.1f%%입니다.", roi);
    }

    private void writeDetailResult(LottoPrize lottoPrize, Integer result) {
        if(lottoPrize.equals(LottoPrize.FIVE_MATCH_BONUS)) {
            write("%d개 일치, 보너스 볼 일치 (%,d원) - %d개",
                    lottoPrize.getMatchCount(),
                    lottoPrize.getPrize(),
                    result);
            return;
        }
        write("%d개 일치 (%,d원) - %d개",
                lottoPrize.getMatchCount(),
                lottoPrize.getPrize(),
                result);
    }

    public void writeLottoList(List<List<Integer>> lottoList) {
        lottoList.forEach(
                lotto ->  write("[%d, %d, %d, %d, %d, %d]", lotto.toArray())
        );
    }
}
