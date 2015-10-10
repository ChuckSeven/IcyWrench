package modules;

import java.net.Socket;

import exceptions.IllegalConfigurationException;
import logmanager.Logger;

/**
 * Defines which kind of request handler should be applied.
 * @author 150021237
 *
 */
public class RequestHandler {

	public static enum HandlerType {
		HTTP
	};

	private static Logger logger = Logger.getInstance();

	private RequestHandler() {}

	public static void use(HandlerType type, Socket s) {
		logger.trace("enter RequestHandler.use()");
		switch (type) {
		case HTTP:
			HttpRequestHandler.request(s);
			break;
		default:
			logger.fatal(null, "No valid handler specified", new IllegalConfigurationException());
		}
	}
}
