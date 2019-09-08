package ru.semenov.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.dto.ProductDTO;
import ru.semenov.entities.Product;
import ru.semenov.services.ProductService;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@WebService
public class ProductSOAP {

    private Logger logger = LoggerFactory.getLogger(ProductSOAP.class);

    @EJB
    private ProductService productService;

    @WebResult(name = "Product")
    @WebMethod
    public List<ProductDTO> getAll() {
        return getProductDTOs(productService.getAll());
    }

    @WebMethod
    public void insert(@WebParam(name = "Product") ProductDTO productDTO) {
        productService.insert(productDTO.getProduct());
    }

    @WebResult(name = "Product")
    @WebMethod
    public ProductDTO findById(@WebParam(name = "id") int id) {
        Product product = productService.findById(id);
        if (product != null) {
            return new ProductDTO();
        }
        return null;
    }

    @WebMethod
    public void merge(@WebParam(name = "Product") ProductDTO productDTO) {
        productService.merge(productDTO.getProduct());
    }

    @WebMethod
    public void delete(@WebParam(name = "Product") ProductDTO entity) {
        productService.delete(entity.getProduct());
    }

    @WebResult(name = "Product")
    @WebMethod
    public List<ProductDTO> findByName(@WebParam(name = "name") String namePart) {
        return getProductDTOs(productService.findByName(namePart));
    }

    @WebResult(name = "Product")
    @WebMethod
    public List<ProductDTO> findByPrice(@WebParam(name = "from") Integer from,
                                        @WebParam(name = "to") Integer to) {
        return getProductDTOs(productService.findByPrice(from, to));
    }

    private List<ProductDTO> getProductDTOs(List<Product> products) {
        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
