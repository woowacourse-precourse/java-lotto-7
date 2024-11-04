package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Output {
    public static void printConsole(String printMessage){
        System.out.println(printMessage);
    }

    public static void printLottoSets(List<List<Integer>> lottoFullSets, Integer lottoSetNumber){
        for (int i = 0; i < lottoSetNumber; i++) {
            System.out.println(lottoFullSets.get(i));
        }
    }
}
