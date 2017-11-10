package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.Category;
import com.realdolmen.thomasmore.service.CategoryService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class CategoryController {
    //Autowired kunnen we niet gebruiken in JSF, daarom gebruiken we hier dit om een spring bean te injecteren.
    @ManagedProperty("#{categoryService}")
    private CategoryService categoryService;

    public List<Category> categories;
    public Category category;

    private Long categoryId;
    private String newName;
    private String newDescription;


    public List<Category> getCategories() {
        return categories = categoryService.findAllCategories();
    }

    //meldingen tonen
    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    //aanmaken product
    public String toNewCategoryPage() {
        return "categorynew?faces-redirect=true";
    }

    public String createCategory() {
        categoryService.createCategory(newName,newDescription);
        clearForm();
        return "categorylist?faces-redirect=true";
    }

    private void clearForm() {
        newName = null;
        newDescription = null;
    }


    //deleten van product
    public String deleteCategory(Long id) {
        categoryService.deleteCategory(id);
        addMessage("Category Deleted!");
        return "redirect:/categorylist.xhtml";
    }


    //updaten van product
    public String toUpdatePage(Long id) {
        category = categoryService.getCategoryById(id);
        return "categoryupdate?faces-redirect=true";
    }

    public String updateCategory(Category category) {
        categoryService.updateCategory(category);
        return "categorylist?faces-redirect=true";
    }




    //getters en setters
    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }


    public Long getCategoryId() { return categoryId; }

    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Deze setter MOET aanwezig zijn, anders kan spring deze service niet injecteren.
     */
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
