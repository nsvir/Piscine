package lille1.piscine;

import lille1.piscine.model.Action;
import lille1.piscine.model.ActionA;
import lille1.piscine.model.ActionB;

public class Main {
    public static void main(String argv[]) {
        Action a = new ActionB();
        System.out.println(a.algo());
    }
}