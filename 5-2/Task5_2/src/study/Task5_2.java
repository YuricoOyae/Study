package study;

public class Task5_2 {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// ①String型のユーザーの名前を格納する変数を定義し、「田中太郎」で初期化して下さい。※変数名はご自身で命名して下さい。
			String name = "田中太郎";
		
				// ②int型の年齢を格納する変数を定義し、25で初期化して下さい。※変数名はご自身で命名して下さい。
			int age = 25;
				
				// ③String型の電話番号を格納する変数を定義し、「090-1234-5678」で初期化して下さい。※変数名はご自身で命名して下さい。
			String phone = "090-1234-5678";	
				
				// ④String型のメールアドレスを格納する変数を定義し、「taro@example.com」で初期化して下さい。※変数名はご自身で命名して下さい。
			String email = "taro@example.com";
				
				// ⑤String型のパスワードを格納する変数を定義し、「pass1234」で初期化して下さい。※変数名はご自身で命名して下さい。
			String pass = "pass1234";
		// ④ユーザーの名前を「田中次郎」に上書きして下さい。
			name = "田中次郎";
		
				// ⑥年齢を「30」に上書きして下さい。
			age = 30;
				
				// ⑦電話番号を「080-9876-5432」に上書きして下さい。
			phone = "080-9876-5432";
				
				// ⑧年齢を1歳加算して下さい。
			age = age + 1;
				
				// ⑨userEmail を再度「jiro.tanaka@example.com」に上書きして下さい。
			email = "jiro.tanaka@example.com";
				
				// ⑩各変数の値を表示
				System.out.println("名前："+ name);
		       System.out.println("年齢："+ age +"歳");
		       System.out.println("電話："+ phone);
		       System.out.println("メール："+ email);
		       System.out.println("パスワード："+pass);

	}

}
