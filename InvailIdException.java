package project;

public class InvailIdException extends  RuntimeException{
	  private String message;
	public InvailIdException(String message){
	   this.message= message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}
