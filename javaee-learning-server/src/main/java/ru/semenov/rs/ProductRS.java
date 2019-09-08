package ru.semenov.rs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ru.semenov.services.ProductService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.stream.Collectors;

@Path("/product")
@Api(value = "ProductService", description = "Just simple REST service")
public class ProductRS {
    @EJB
    ProductService productService;

    @GET
    @Produces("application/json")
    @Path("/all")
    @ApiOperation(value = "Get all products")
    public String getAll() {
        return productService.getAll().stream().map(x -> x.toString()).collect(Collectors.joining(" "));
    }

}
