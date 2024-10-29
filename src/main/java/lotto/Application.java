package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력기능
        System.out.println("구입 가격을 입력해주세요.");
        int price = Integer.parseInt(Console.readLine());

        System.out.println("당첨번호를 입력해주세요.");
        String winningNumber = Console.readLine();

        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNumber = Console.readLine();

        // 로또 번호 리스트 저장
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

        // 당첨 여부 체크
        int[] winningCount = {0, 0, 0, 0, 0};
        String[] winningNumberText = winningNumber.split(",");
        int[] winningNumberList = new int[6];

        for(int i=0; i<winningNumberText.length; i++){
            winningNumberList[i] = Integer.parseInt(winningNumberText[i]);
        }

        for(int i=0; i<lottoNumberList.length; i++){
            int match = 0;
            boolean bonusCheck = false;
            for(int j=0; j<lottoNumberList[0].length; j++){
                for(int k=0; k<winningNumberList.length; k++){
                    if(lottoNumberList[i][j] == winningNumberList[k]){
                        match++;
                    }
                }
            }

            if(match == 5){
                for(int l=0; l<winningNumberList.length; l++){
                    if(Integer.parseInt(bonusNumber) == winningNumberList[l]){
                        bonusCheck = true;
                    }
                }
            }

            switch(match){
                case 6 : winningCount[4]++;
                         break;
                case 5 : if(bonusCheck){
                            winningCount[3]++;
                         }else{
                            winningCount[2]++;
                         }
                         break;
                case 4 : winningCount[1]++;
                         break;
                case 3 : winningCount[0]++;
                default : System.out.println("꽝");
                          break;
            }
        }

    }
}
