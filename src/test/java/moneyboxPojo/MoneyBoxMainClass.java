package moneyboxPojo;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MoneyBoxMainClass {
	
	public static void main(String[] args) throws Exception
	{
		ReloadAmount reloadAmount = new ReloadAmount();
		reloadAmount.setValue("80.00");
		reloadAmount.setCurrency("USD");
		System.out.println(reloadAmount);
		System.out.println(convertToJson(reloadAmount)+"\n");
		
		TransferSetting transferSetting = new TransferSetting();
		transferSetting.setRecurrence("WEEKLY");
		transferSetting.setStart_date("2018-04-28");
		transferSetting.setFinancial_instrument_id("HO-9RBQD57HHHHJW");
		transferSetting.setReload_amount(reloadAmount);
		transferSetting.setType("SCHEDULE");
		System.out.println(transferSetting);
		System.out.println(convertToJson(transferSetting)+"\n");
		
//To ADD IT IN ARRAY FORMAT AND PASS TO PARENT (MONEYBOX)
		List<TransferSetting> transfSett = new ArrayList<TransferSetting>();
		transfSett.add(transferSetting);
		//transfSett.add(transferSetting); 			//To Add multiple Rows in an array
		
		System.out.println(convertToJson(transfSett));
		
		Moneybox moneyBox = new Moneybox();
		moneyBox.setName("New Car");
		moneyBox.setType("SAVING");
		moneyBox.setCategory("GOAL");
		moneyBox.setTransfer_settings(transfSett);
		System.out.println(convertToJson(moneyBox)+"\n");
		
		
		Example example = new Example();
		example.setMoneybox(moneyBox);
		System.out.println(convertToJson(example)+"\n");
		
	}
	
	
	public static String convertToJson(Object obj) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

}
