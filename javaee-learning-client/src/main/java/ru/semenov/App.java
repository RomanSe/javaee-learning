package ru.semenov;

import ru.semenov.ws.ProductDTO;
import ru.semenov.ws.ProductSOAP;
import ru.semenov.ws.ProductSOAPService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/javaee-learning/ProductSOAP?WSDL");
        ProductSOAPService soapService = new ProductSOAPService(url);
        ProductSOAP service = soapService.getProductSOAPPort();

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("New brand product");
        productDTO.setDescription("Super super new");
        productDTO.setPrice(8389);
        service.insert(productDTO);

        List<ProductDTO> products = service.getAll();
        products.stream().map(App::productToString).forEach(System.out::print);
    }

    private static String productToString(ProductDTO productDTO) {
        return "ProductDTO{" +
                "id=" + productDTO.getId() +
                ", name='" + productDTO.getName() + '\'' +
                ", description='" + productDTO.getDescription() + '\'' +
                ", image='" + productDTO.getImage() + '\'' +
                ", price=" + productDTO.getPrice() +
                "}\n";
    }
}


