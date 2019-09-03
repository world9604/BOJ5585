import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         * 거스름돈 문제는 가장 대표적인 그리디 알고리즘 문제 입니다.
         * 손님이 물건을 골라서 1000엔 지폐를 지불한 경우 거슬러 주어야 하는 잔돈의 최소 갯수를 구해야 합니다.
         * 따라서 입력으로 들어온 숫자를 1000에서 뺀 뒤에 500, 100, 50, 10, 5, 1
         * 순서대로 잔돈을 차례대로 최대로 거슬러 주면 됩니다.
         * https://www.acmicpc.net/problem/5585
         */
        Scanner sc = new Scanner(System.in);
        int inputMoney = Integer.parseInt(sc.nextLine());
        new Greedy(inputMoney).caculate();
    }
}


class Greedy {
    public static final int TAKED_MONEY = 1000;
    public static final int FIVE_HUNDRED_MONENY = 500;
    public static final int ONE_HUNDRED_MONENY = 100;
    public static final int FIFTY_MONENY = 50;
    public static final int TEN_MONENY = 10;
    public static final int FIVE_MONENY = 5;
    private int price;
    private int changeMoney;
    private int changeMoneyCnt;

    Greedy(int price) {
        this.price = price;
        this.changeMoney = 0;
        this.changeMoneyCnt = 0;
    }

    public void caculate() {
        changeMoney = TAKED_MONEY - price;
        caculateByUnit(FIVE_HUNDRED_MONENY);
        caculateByUnit(ONE_HUNDRED_MONENY);
        caculateByUnit(FIFTY_MONENY);
        caculateByUnit(TEN_MONENY);
        caculateByUnit(FIVE_MONENY);
        changeMoney += changeMoneyCnt;
        System.out.printf("%d", changeMoneyCnt);
    }

    private void caculateByUnit(int monenyUnit) {
        changeMoneyCnt += (changeMoney / monenyUnit);
        changeMoney %= monenyUnit;
    }
}