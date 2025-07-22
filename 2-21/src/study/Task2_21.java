package study;

	import java.util.ArrayList;
import java.util.HashMap;
	
public class Task2_21 {
    public static final String orange = "オレンジ";
    public static final String grape = "ぶどう";
    public static final String apple = "りんご";
    public static final String pear = "梨";

    public static void main(String[] args) {
        ArrayList<String> fruitsArrayList = new ArrayList<>();
        fruitsArrayList.add(apple);
        fruitsArrayList.add(grape);
        fruitsArrayList.add(pear);
        fruitsArrayList.add(orange);
        
        HashMap<String, Integer> fruitsHashMap = new HashMap<>();
        fruitsHashMap.put(apple, 180);
        fruitsHashMap.put(grape, 120);
        fruitsHashMap.put(pear, 140);
        fruitsHashMap.put(orange, 150);
        
        fruitsHashMap.put(orange, 200);
     
     for (String fruit : fruitsArrayList) {
            int price = fruitsHashMap.get(fruit);
            System.out.println(fruit + "の値段は" + price + "です。");
        }
    }
}
