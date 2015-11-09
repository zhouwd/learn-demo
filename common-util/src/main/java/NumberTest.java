import java.text.NumberFormat;

public class NumberTest {

	public static void main(String[] args) {
		NumberFormat currencyInstance = NumberFormat.getNumberInstance();
		currencyInstance.setMinimumFractionDigits(2);
		//currencyInstance.setGroupingUsed(false);//加不加逗号
		System.out.println(currencyInstance.format(12345.0000));
	}
}
