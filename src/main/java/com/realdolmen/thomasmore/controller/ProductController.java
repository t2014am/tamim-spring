package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.Product;
import com.realdolmen.thomasmore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.File;
import java.util.*;

@ManagedBean
@SessionScoped
public class ProductController {
    //Autowired kunnen we niet gebruiken in JSF, daarom gebruiken we hier dit om een spring bean te injecteren.
    @ManagedProperty("#{productService}")
    private ProductService productService;

    public List<Product> products;
    public List<Product> productsOrderd;
    public Product product;
    private Long productId;
    private String newName;
    private int newPrice;
    private String newDescription;
    private int newStock;
    private Long newCategoryId;
    private String newImage;


    @Autowired
    ServletContext context;



    public List<Product> getProducts() {
           return products = productService.findAllProducts();
    }

    //meldingen tonen
    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    //aanmaken product
    public String toNewProductPage() {
        return "productnew?faces-redirect=true";
    }

    public String createProduct() {
        productService.createProduct(newName, newPrice, newDescription, newStock, newCategoryId);
        clearForm();
        return "productnew?faces-redirect=true";
    }

    private void clearForm() {
        newName = null;
        newDescription = null;
    }


    //deleten van product
    public String deleteProduct(Long id) {
        productService.deleteProduct(id);
        addMessage("Product Deleted!");
        return "redirect:/index.xhtml";
    }


    //updaten van product
    public String toUpdatePage(Long id) {
        product = productService.getProductById(id);
        addMessage("update product" + product.getName());
        return "productupdate?faces-redirect=true";
    }
    public String toProductPage(Long id) {
        product = productService.getProductById(id);
        addMessage("Detail product " + product.getName());
        return "productdetail?faces-redirect=true";
    }

    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "productupdate?faces-redirect=true";
    }


    //sorteren van producten
    public String orderByNameAsc() {
        products = productService.findAllProductsOrderByNameAsc();
        return "redirect:/productlist.xhtml";
    }

    public  String orderByNameDesc() {
        products = productService.findAllProductsOrderByNameDesc();
        return "redirect:/productlist.xhtml";
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getNewImage() {
        return newImage;
    }

    public void setNewImage(String newImage) {
        this.newImage = newImage;
    }
    //getters en setters voor categorie
    public Long getNewCategoryId() {
        return newCategoryId;
    }

    public void setNewCategoryId(Long newCategoryId) {
        this.newCategoryId = newCategoryId;
    }

    /**
     * Deze setter MOET aanwezig zijn, anders kan spring deze service niet injecteren.
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
