import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/RestService")
public class Rest {
    @GET
    @Path("/get")
    @Produces("application/json")
    public Product getProductInJSON() {

        Product product = new Product();
        product.setName("iPad 3");
        product.setQty(999);

        return product;
    }

    @GET
    @Path("/plain")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello World RESTful Jersey!";
    }
    @GET
    @Path("/xml")
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?>" + "<hello> Hello World RESTful Jersey"
                + "</hello>";
    }

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "<html> " + "<title>" + "Hello World RESTful Jersey"
                + "</title>" + "<body><h1>" + "Hello World RESTful Jersey"
                + "</body></h1>" + "</html> ";
    }

}
