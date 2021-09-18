package com.rianta9.mona.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 15 thg 9, 2021
 * @version 1.0
 * @see
 */
public class MoneyHelper {
	/**
	 * Trả về chuỗi định dạng xxx.xxx.xxx đ
	 * @param money
	 * @return
	 */
	public static String toMoneyType(BigDecimal money) {
		if(money == null) money = new BigDecimal(0);
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		return formatter.format(money) + " đ";
	}
	
	
	/**
	 * Trả về chuỗi định dạng xxx.xxx.xxx đ
	 * @param money
	 * @return
	 */
	public static String toMoneyType(Long money) {
		if(money == null) money = 0l;
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		return formatter.format(money) + " đ";
	}
	
	/**
	 * Trả về chuỗi định dạng xxx.xxx.xxx đ
	 * @param money
	 * @return
	 */
	public static String toMoneyType(Double money) {
		if(money == null) money = 0d;
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		return formatter.format(money) + " đ";
	}
}
