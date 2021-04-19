package student.ui.exception;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class InvalidChechException extends RuntimeException { //전파. 계속 위롱 ㅗㄹ라간다

	public InvalidChechException() {
	//	JOptionPane.showMessageDialog(null, "공백이 존재합니다.");
		super("공백이 존재합니다.");
//
	}

	public InvalidChechException(Throwable cause) {
		super("공백이 존재합니다.",cause);
		
	}

	public InvalidChechException(String message) {
	
		super(message);
	
	}
	

}
