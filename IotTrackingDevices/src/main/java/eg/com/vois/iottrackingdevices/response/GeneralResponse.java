package eg.com.vois.iottrackingdevices.response;


import org.springframework.stereotype.Component;

@Component
public class GeneralResponse {
	private String message;
    private int status;
   
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
