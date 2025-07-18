package study;

public class Task2_15 {

	public static String red = "赤";
	public static String blue = "青";

 public static void main(String[] args) {
    Bike bike1 = new Bike();
    Bike bike2 = new Bike();
	
    bike1.run(); // bike1 → 走行中
    bike2.stop();// bike2 → 停止中
    
    System.out.println("car1は" + red + "色で" + bike1.type + "タイプです。 現在" + bike1.check());
    System.out.println("car2は" + blue + "色で" + bike2.type + "タイプです。 現在" + bike2.check());
 }
}
class Bike {
    String color;
    String type;
    Boolean state;

    // 引数なしのコンストラクタ
    public Bike() {
        this.color = "未設定";
        this.type = "250cc"; // デフォルト値は250cc
    }

    public void run() {
        this.state = true;
    }

    public void stop() {
        this.state = false;
    }

    public String check() {
        if (this.state != null && this.state) {
            return "走行中です。";
        } else {
            return "停止中です。";
        }
    }
}
	

