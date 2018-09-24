package ch9;

public class Logger {
	private State state;
	
	public Logger() {
		this.state = State.STOPPED;
	}
	
	public String start() {
		var msg = this.state.start();
		this.state = State.LOGGING;
		return msg;
	}
	
	public String stop() {
		var msg = this.state.stop();
		this.state = State.STOPPED;
		return msg;
	}
	
	public String log(String info) {
		return this.state.log(info);
	}
}
