package ru.semenov.jsf;


import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.entities.Product;
import ru.semenov.repositories.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@SessionScoped
@Named
public class ProductsBean implements Serializable {

    private Logger logger = LoggerFactory.getLogger(ProductsBean.class);

    private UploadedFile file;

    private Product product;

    @Inject
    private ProductRepository productRepository;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getAll() {
        logger.info("Get all products:" + productRepository.getAll().size());
        return productRepository.getAll();
    }

    public String editProduct(Product product) {
        this.file = null;
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public String createProduct() {
        this.file = null;
        this.product = new Product();
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public String saveProduct() {
        productRepository.merge(product);
        this.file = null;
        return "/catalog.xhtml?faces-redirect=true";
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() {
        logger.info("File uploader");
        if (file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {
        logger.info(event.getFile().getFileName() + " is uploaded.");
        file = event.getFile();
        FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        Path path = Paths.get(context.getInitParameter("images.path"), product.getId() + "." + FilenameUtils.getExtension(file.getFileName()));
        Files.copy(file.getInputstream(), path, StandardCopyOption.REPLACE_EXISTING);
        logger.info("File " + path + " is saved");
        product.setImage(path.toString());
        product.setImageContentType(file.getContentType());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public StreamedContent getImage(Product product) {
        logger.info("Getting image " + product.getImage() + " with content-type " + product.getImageContentType());
        if (product.getImage() != null) {
            try {
                return new DefaultStreamedContent(new FileInputStream(product.getImage()), product.getImageContentType());
            } catch (FileNotFoundException e) {
                logger.warn("Image no found: " + product.getImage());
            }
        }
        logger.info("Getting image failed");
        return new DefaultStreamedContent();
    }
}
