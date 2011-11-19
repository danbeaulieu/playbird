package controllers.playbird;

import play.Logger;
import play.mvc.Controller;
import play.mvc.WebSocketController;

public class PlaybirdWebSocket extends Controller {

	public static class StreamSocket extends WebSocketController {

		/**
		* Index.
		*/
		public static void index() {
			Logger.info("Got connection");
			while (inbound.isOpen()) {
				try {
					play.libs.F.Promise<Integer> promise = play.modules.playbird.PlaybirdPlugin.hitStream.nextEvent();
					Integer event = await(promise);
					Logger.info("Publishing Event %s to Outbound Subscribers", 1);
					outbound.send(event.toString());
		
				} catch (Throwable t) {
					Logger.error("Caught error", t);
				}
			}
		}
	}
}
