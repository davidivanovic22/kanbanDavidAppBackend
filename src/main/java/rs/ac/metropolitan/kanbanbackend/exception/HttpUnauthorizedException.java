package rs.ac.metropolitan.kanbanbackend.exception;

public class HttpUnauthorizedException extends RuntimeException {
	public HttpUnauthorizedException() {
	}

	public HttpUnauthorizedException(String s) {
		super(s);
	}

	public HttpUnauthorizedException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public HttpUnauthorizedException(Throwable throwable) {
		super(throwable);
	}
}
