package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.Product;
import com.realdolmen.thomasmore.service.ProductService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProductController {
    //Autowired kunnen we niet gebruiken in JSF, daarom gebruiken we hier dit om een spring bean te injecteren.
    @ManagedProperty("#{productService}")
    private ProductService productService;

    public List<Product> products;
    public Product product;

    private Long productId;
    private String newName;
    private int newPrice;
    private String newDescription;
    private int newStock;

    public List<Product> getProducts() {
        return products = productService.findAllProducts();
    }

    public void createProduct() {
        productService.createProduct(newName,newPrice,newDescription,newStock);
        addMessage("Product toegevoegd!");
        clearForm();
    }

    private void clearForm() {
        newName = null;
        newDescription = null;
    }

    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String deleteProduct(Long id) {
        productService.deleteProduct(id);
        addMessage("Product Deleted!");
        return "redirect:/productlist.xhtml";
    }

    public Product getProduct(Long id) {
        return product = productService.getProductById(id);
    }

    public String toUpdatePage(Long id) {
        getProduct(id);
        addMessage("update product" );
        return "productupdate?faces-redirect=true";
    }


    //getters en setters
    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public int getNewStock() {
        return newStock;
    }

    public void setNewStock(int newStock) {
        this.newStock = newStock;
    }

    public Long getProductId() { return productId; }

    public void setProductId(Long productId) { this.productId = productId; }

    /**
     * Deze setter MOET aanwezig zijn, anders kan spring deze service niet injecteren.
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
