import com.test.GenericsTest;
import com.test.base.BaseTest;
import com.test.DataStructureTest;
import com.test.base.SerializeTest;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Start Test!");
        // BaseTest baseTest = new DataStructureTest();
        // BaseTest baseTest = new GenericsTest();
        BaseTest baseTest = new SerializeTest();
        baseTest.runTest();
    }
}