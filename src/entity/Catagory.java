package entity;

public class Catagory {

    private String CatID;
    private String CategoryName;

    public Catagory(String catID, String categoryName) {
        CatID = catID;
        CategoryName = categoryName;
    }

    public Catagory() {
    }

    public String getCatID() {
        return CatID;
    }

    public void setCatID(String catID) {
        CatID = catID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
