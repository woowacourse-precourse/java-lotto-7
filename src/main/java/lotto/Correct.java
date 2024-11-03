package lotto;

import static lotto.Application.*;

public class Correct {

    public static void iterator() {
        for (int t=0;t<lottoCount;t++) {
            correctJudge(lottos[t]);
        }
    }

    public static int judgeNumber(int number) {
        int result = 0;
        for (int j=0;j<6;j++) {
            result+=isCorrect(number, winningNumber.getNumbers().get(j));
        }
        return result;
    }

    public static int isCorrect(int a, int b) {
        if (a==b) {
            return 1;
        }
        return 0;
    }

    public static void correctJudge(Lotto lotto) {
        int num = 0;
        int bonusCorrect = 0;
        for (int c=0;c<6;c++) {
            num+=judgeNumber(lotto.getNumbers().get(c));
            bonusCorrect+=isCorrect(lotto.getNumbers().get(c),bonusNumber);
        }
        if (num==3) {
            correctDetail[0]++;
        }
        if (num==4) {
            correctDetail[1]++;
        }
        if (num==5 && bonusCorrect==1) {
            correctDetail[3]++;
        }
        if (num==5) {
            correctDetail[2]++;
        }
        if (num==6) {
            correctDetail[4]++;
        }
    }

    public static double profit() {
        double sum = 0;
        for (int p=0;p<5;p++) {
            sum+=(double) correctDetail[p]*reward[p];
        }
        return sum;
    }
}
