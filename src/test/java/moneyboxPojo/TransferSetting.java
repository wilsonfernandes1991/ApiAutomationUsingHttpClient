package moneyboxPojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferSetting {
	
	private String recurrence;
	private String start_date;	
	private String financial_instrument_id;
	private ReloadAmount reload_amount;
	private String type;
	
	
	public String getRecurrence() {
		return recurrence;
	}
	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getFinancial_instrument_id() {
		return financial_instrument_id;
	}
	public void setFinancial_instrument_id(String financial_instrument_id) {
		this.financial_instrument_id = financial_instrument_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	public ReloadAmount getReloadAmount() {
		return reload_amount;
	}
	public void setReload_amount(ReloadAmount reload_amount) {
		this.reload_amount = reload_amount;
	}
	
	public String toString()
	{
		return "TransferSetting[recurrence="+recurrence+", start_date="+start_date+", financial_instrument_id="+financial_instrument_id+", reload_amount="+reload_amount+"]";
	}

}
