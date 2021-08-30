package dto;

public class CatagoryDTO {

    private String CatID;
    private String CategoryName;

    public CatagoryDTO(String catID, String categoryName) {
        CatID = catID;
        CategoryName = categoryName;
    }

    public CatagoryDTO() {
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
