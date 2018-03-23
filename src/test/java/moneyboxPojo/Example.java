package moneyboxPojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Example {

	private Moneybox moneybox;

	public Moneybox getMoneybox() {
		return moneybox;
	}

	public void setMoneybox(Moneybox moneybox) {
		this.moneybox = moneybox;
	}
	
}
