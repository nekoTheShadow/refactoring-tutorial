package util;

public class RefactoringRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RefactoringRuntimeException(String msg) {
		super(msg);
	}
	
	public RefactoringRuntimeException(Throwable e) {
		super(e);
	}
}
