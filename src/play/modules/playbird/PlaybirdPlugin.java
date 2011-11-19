package play.modules.playbird;

import play.PlayPlugin;

public class PlaybirdPlugin extends PlayPlugin {

	public static play.libs.F.EventStream<Integer> hitStream = new play.libs.F.EventStream<Integer>();
}
