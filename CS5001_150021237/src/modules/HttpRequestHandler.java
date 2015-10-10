package modules;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import Parser.HttpParser;
import logmanager.Logger;

/**
 * Can process http request.
 * @author 150021237
 *
 */
class HttpRequestHandler {

	private static Logger logger = Logger.getInstance();

	private HttpRequestHandler() {
	}

	public static void request(Socket s) {
		logger.trace("enter HttpRequestHandler.request()");

		try {
			try {
				Map<String, String> header = HttpParser.getHttpHeader(s.getInputStream());
				String content = HttpParser.getContent(s.getInputStream());
								
			} catch (Exception e) {
				logger.error(s.getInetAddress().getHostAddress(), "Illegal Header Format", e);
			}
			
			s.close();
			
		} catch (IOException e) {
			logger.error("Socket close exception", e);
		}

	}

}