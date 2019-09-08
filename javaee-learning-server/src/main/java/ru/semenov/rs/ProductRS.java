package ru.semenov.rs;

import ru.semenov.dto.ProductDTO;
import ru.semenov.services.ProductService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/product")
public class ProductRS {
    @EJB
    ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<ProductDTO> getAll() {

        return productService.getAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

}
