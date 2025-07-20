package study;

public class Task2_16 {
	public static void main(String[] args) {
    String firstName = "ゆりこ";
    String lastName = "親衛";
    
    System.out.println(getName(firstName, lastName));
    System.out.println();

    int[] arr = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    for (int num : arr) {
        isOdd(num);
    }
}

    public static String getName(String firstName, String lastName) {
        return firstName + lastName;
    }

    public static void isOdd(int num) {
        if (num % 2 != 0) {
            System.out.println(num + "は奇数です。");
        }
      }
	}


