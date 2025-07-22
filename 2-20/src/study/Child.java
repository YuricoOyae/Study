package study;

	public class Child extends Parent {
	
	    public void callName() {
	        super.name(); // 親の name() を呼び出す
	    }
	    @Override
	    public void update() {
	        System.out.println("上書きされました。");
	    }
	}
