
public class StartScreen {
	private boolean active;
	
	StartScreen() {
		active = true;
	}
	
	void exit(){
		active = false;
	}
	
	void activate(){
		active = true;
	}
	
	boolean check() {
		return active;
	}
}
