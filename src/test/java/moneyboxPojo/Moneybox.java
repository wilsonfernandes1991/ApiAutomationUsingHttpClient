package moneyboxPojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Moneybox {
	
	private String name;
	private String type;
	private String description;
	private String category;
	private List<TransferSetting> transfer_settings;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<TransferSetting> getTransfer_settings() {
		return transfer_settings;
	}
	public void setTransfer_settings(List<TransferSetting> transfer_settings) {
		this.transfer_settings = transfer_settings;
	}


}
