import java.net.URI; 

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;


public class Client {

    private static final String webServiceURI = "http://localhost:8080/Server";

    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        javax.ws.rs.client.Client client = ClientBuilder.newClient(clientConfig);
        URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
        WebTarget webTarget = client.target(serviceURI);

        // response
        System.out.println(webTarget.path("rest").path("RestService").request()
                .accept(MediaType.TEXT_PLAIN).get(Response.class).toString());

        // text
        System.out.println(webTarget.path("rest").path("RestService/plain").request()
                .accept(MediaType.TEXT_PLAIN).get(String.class));

        // xml
        System.out.println(webTarget.path("rest").path("RestService/xml").request()
                .accept(MediaType.TEXT_XML).get(String.class));

        // html
        System.out.println(webTarget.path("rest").path("RestService/html").request()
                .accept(MediaType.TEXT_HTML).get(String.class));

        System.out.println(webTarget.path("rest").path("RestService/get/post").request()
                .accept("application/json").get(String.class));
    }
}