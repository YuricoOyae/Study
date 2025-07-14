public class Task2_11 {
    public static void main(String[] args){
    /*
    *問①
    int型の変数 a と b を宣言し、それぞれ10と3を代入して、次の演算を行い、結果を表示して下さい：
    ・a と b の和
    ・a と b の差
    ・a と b の積
    ・a と b の商
    ・a を b で割った余り
    */
        int a = 10;
        int b = 3;
        System.out.println("和： " + (a + b));
        System.out.println("差： " + (a - b));
        System.out.println("積： " + (a * b));
        System.out.println("商： " + (a / b));
        System.out.println("余り： " + (a % b));


    /*
    * 問題②
    * int型の配列を宣言し、1から20までの偶数を格納して、ループを使用してそれらの整数を順番に表示して下さい。
    */
               for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
        }
        
    //問題③ 奇数かどうかの判定をするために、for文で取得したnumberを2で割り、余りが0にならないような条件文(if文)を記載して下さい。
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int add = sumOddNumbers(numbers);
        System.out.println("奇数の合計: " + add);
    }

    public static int sumOddNumbers(int[] numbers) {
        int add = 0;

        for (int i = 0; i < numbers.length; i++) {
            // 奇数判定: 2で割った余りが0でなければ奇数
            if (numbers[i] % 2 != 0) {
                add += numbers[i];
            }
        }
        return add;
    }
}
