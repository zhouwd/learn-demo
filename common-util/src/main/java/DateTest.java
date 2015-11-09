import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DateTest {
	public static void date2StrTest(){
		System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
	}

	public static void str2DateTest(){
		try {
			System.out.println(DateUtils.parseDate("2015-01-01", "yyyy-MM-dd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		date2StrTest();
		str2DateTest();
	}
}
