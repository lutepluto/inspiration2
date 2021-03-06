package runtime;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;

public class Inspiration2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		long begin = System.currentTimeMillis();
        Connector connector = new SelectChannelConnector();
        connector.setPort(Integer.getInteger("jetty.port", 8080).intValue());

        WebAppContext webapp = new WebAppContext("webapp", "/inspiration2");
		webapp.setDefaultsDescriptor("./src/test/resources/runtime/webdefault.xml");
        
        Server server = new Server();
        server.setConnectors(new Connector[] { connector });
        server.setHandler(webapp);
        server.start();
        System.out.println("Jetty Server started, use " + (System.currentTimeMillis() - begin) + " ms");
	}

}
