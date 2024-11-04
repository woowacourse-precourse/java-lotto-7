package lotto;


import static java.math.BigInteger.valueOf;
import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.math.BigInteger;


public class ResultReport {
    Integer[] prizeArray;
    HashMap<String,Integer> hashMap = new HashMap<>();
    String earningRate;
    BigDecimal total;
    BigDecimal reward1 = new BigDecimal("2000000000");
    BigDecimal reward2 = new BigDecimal("30000000");
    BigDecimal reward3 = new BigDecimal("1500000");
    BigDecimal reward4 = new BigDecimal("50000");
    BigDecimal reward5 = new BigDecimal("5000");

    ResultReport(Integer[] prizeArr){
        this.prizeArray =prizeArr;
        HashMap<String,Integer> hashMap = new HashMap<>();
    }

    void mappingLotto(){
        List<Integer> prizeCount = new ArrayList<>();
        prizeCount.add(0);
        for (int i = 1; i<6 ; i++){
            int count = Collections.frequency(Arrays.asList(this.prizeArray), i);
            prizeCount.add(count);
        }
        this.hashMap.put("5", prizeCount.get(5));
        this.hashMap.put("4", prizeCount.get(4));
        this.hashMap.put("3", prizeCount.get(3));
        this.hashMap.put("2", prizeCount.get(2));
        this.hashMap.put("1", prizeCount.get(1));
    }

    void computeEarningRate(){

        BigDecimal reward1 = this.reward1.multiply(BigDecimal.valueOf(this.hashMap.get("1")));
        BigDecimal reward2 = this.reward2.multiply(BigDecimal.valueOf(this.hashMap.get("2")));
        BigDecimal reward3 = this.reward3.multiply(BigDecimal.valueOf(this.hashMap.get("3")));
        BigDecimal reward4 = this.reward4.multiply(BigDecimal.valueOf(this.hashMap.get("4")));
        BigDecimal reward5 = this.reward5.multiply(BigDecimal.valueOf(this.hashMap.get("5")));

        BigDecimal count = new BigDecimal(Integer.toString(this.prizeArray.length));
        BigDecimal money = count.multiply(BigDecimal.valueOf(10));
        BigDecimal total = reward1.add(reward2.add(reward3.add(reward4.add(reward5))));
        BigDecimal earningRate = total.divide(money,1, RoundingMode.HALF_UP);

        this.total = total;
        this.earningRate = String.valueOf(earningRate);
    }

    void printReport(){
        mappingLotto();
        computeEarningRate();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+this.hashMap.get("5")+"개");
        System.out.println("4개 일치 (50,000원) - "+this.hashMap.get("4")+"개");
        System.out.println("5개 일치 (1,500,000원) - "+this.hashMap.get("3")+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+this.hashMap.get("2")+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+this.hashMap.get("1")+"개");
        System.out.println("총 수익률은 "+this.earningRate+"%입니다.");
    }

}
