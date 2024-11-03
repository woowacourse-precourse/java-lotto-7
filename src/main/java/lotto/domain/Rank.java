package lotto.domain;

import net.bytebuddy.dynamic.scaffold.TypeInitializer;


public enum Rank {
    FIRST(6,false,2000000000,"6개 일치 (2,000,000,000원)"),
    SECOND(5,true,30000000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5,false,1500000,"5개 일치 (1,500,000원)"),
    FOURTH(4,false,50000,"4개 일치 (50,000원)"),
    FIFTH(3,false,5000,"3개 일치 (5,000원)");

    private int match_number;
    private boolean is_bouns_number;
    private int price;
    private String message;

    Rank(int match_number, boolean is_bouns_number, int price, String message) {
        this.match_number = match_number;
        this.is_bouns_number = is_bouns_number;
        this.price = price;
        this.message=message;
    }
    public int getMatch_number() {
        return match_number;
    }
    public int getPrice() {
        return price;
    }
    public boolean get_is_bouns_number() {
        return is_bouns_number;
    }
    public String getMessage() {
        return message;
    }
    public static Rank check_Rank(int count, boolean is_bouns_number){
        for(Rank ranks:values()){
            if(check_number_And_bouns_number(ranks,count,is_bouns_number)) return ranks;
        }
        return null;
    }

    private static boolean check_number_And_bouns_number(Rank rank,int count, boolean is_bouns_number) {
        if(count==SECOND.match_number) return is_bouns_number==rank.get_is_bouns_number();
        return rank.getMatch_number()==count;
    }
}
