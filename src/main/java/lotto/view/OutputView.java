package lotto.view;

import java.util.List;

import lotto.controller.OutputController;

import java.util.Collections;

public class OutputView {
    public static void printLottoNumbers(List<List<Integer>> lottoNumbersList){
        for (List<Integer> lottoNumbers : lottoNumbersList) {
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers); // 각 로또 번호 리스트 출력
        }
        System.out.println();
    }

    public static void printWinningStatistics(int[] matchPoints, double profitRate) {
        System.out.println("당첨통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", matchPoints[2]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", matchPoints[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", matchPoints[4]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", matchPoints[5]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", matchPoints[6]);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
