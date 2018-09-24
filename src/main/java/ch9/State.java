package ch9;

public enum State {
	LOGGING {
		@Override
		public String start() {
			return "";
		}

		@Override
		public String stop() {
			return "*** STOP LOGGING ***";
		}

		@Override
		public String log(String info) {
			return "Logging: " + info;
		}
	},
	STOPPED {
		@Override
		public String start() {
			return "*** START LOGGING ***";
		}

		@Override
		public String stop() {
			return "";
		}

		@Override
		public String log(String info) {
			return "Ignoring: " + info;
		}
	};
	
	public abstract String start();
	public abstract String stop();
	public abstract String log(String info);
}
