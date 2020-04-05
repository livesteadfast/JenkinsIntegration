package livesteadfast.factory;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryMainTest {

	 @Factory()
	    @Test
	    public Object[] getTestFactoryMethod() {
	        Object[] ft = new Object[2];
	        ft[0] = new FactoryOneTest();
	        ft[1] = new FactoryTwoTest();
	        return ft;
	    }

}
