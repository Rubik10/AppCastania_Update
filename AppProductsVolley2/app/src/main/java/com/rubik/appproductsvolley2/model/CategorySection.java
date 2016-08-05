package com.rubik.appproductsvolley2.model;

import java.util.List;

/**
 * Created by Rubik on 2/8/16.
 */
public class CategorySection {


    private String CategoryHeaderTitle;
    private List<Product> allProducInSection;

    public CategorySection (){}

    public CategorySection(String categoryheaderTitle, List<Product> allProducInSection) {
        CategoryHeaderTitle = categoryheaderTitle;
        this.allProducInSection = allProducInSection;
    }

    public String getCategoryHeaderTitle() {
        return CategoryHeaderTitle;
    }

    public void setCategoryHeaderTitle(String categoryHeaderTitle) {
        CategoryHeaderTitle = categoryHeaderTitle;
    }

    public List<Product> getAllProducInSection() {
        return allProducInSection;
    }

    public void setAllProducInSection(List<Product> allProducInSection) {
        this.allProducInSection = allProducInSection;
    }

}
