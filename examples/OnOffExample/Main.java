package example;

import java.io.Console;

import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;
import com.github.oxo42.stateless4j.delegates.Action1;
import com.github.oxo42.stateless4j.transitions.Transition;

public class Main {
	public static void main(String[] args) {
		try
	    {
	        String on = "On", off = "Off";
	        char space = ' ';
	
	        StateMachine<String, Character> onOffSwitch = new StateMachine<String, Character>(off);
	
	        onOffSwitch.configure(off).permit(space, on);
	        onOffSwitch.configure(on).permit(space, off);
	
	        System.out.println("Press <space> to toggle the switch. Any other key will raise an error.");
	
	        while (true)
	        {
	        	System.out.println("Switch is in state: " + onOffSwitch.getState());
	            char pressed = (char)System.in.read();
	            onOffSwitch.fire(pressed);
	        }
	    }
	    catch (Exception ex)
	    {
	    	System.out.println("Exception: " + ex.getMessage());
	    	waitForEnter();
	    }
	}
	
	public static void waitForEnter() {
	    Console c = System.console();
	    if (c != null) {
	        c.format("\nPress ENTER to proceed.\n");
	        c.readLine();
	    }
	}
}
