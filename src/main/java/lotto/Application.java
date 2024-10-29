package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입 가격을 입력해주세요.");
        int price = Integer.parseInt(Console.readLine());

        System.out.println("당첨번호를 입력해주세요.");
        String winnigNumber = Console.readLine();

        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNumber = Console.readLine();

        
        int[][] lottoNumberList = new int[price / 1000][6];

        for(int i=0; i<lottoNumberList.length; i++){
            for(int j=0; j<lottoNumberList[0].length; j++){
                lottoNumberList[i][j] = Randoms.pickNumberInRange(1,45);
                for(int k=0; k<j; k++){
                    if(lottoNumberList[i][j] == lottoNumberList[i][k]){
                        j--;
                    }
                }
            }
        }

        for(int i=0; i<lottoNumberList.length; i++){
            Arrays.sort(lottoNumberList[i]);
        }
    }
}
