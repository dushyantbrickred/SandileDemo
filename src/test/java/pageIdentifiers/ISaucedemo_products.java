package pageIdentifiers;

public interface ISaucedemo_products {
    String homeFilterXpath = "//select[@class='product_sort_container']";
    String homeFilteredOptionXpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]";

    /*
        Oder of items identifiers.
    */
    String firstProductInListCss = ".inventory_list>div:nth-child(1)>div:nth-child(1)>#item_2_img_link";
    String sixthProductInListCss = ".inventory_list>div:nth-child(6)>div:nth-child(1)>#item_5_img_link";



    /*
        For adding items to cart.
     */
    String add_to_cart_sauce_labs_onesieID = "add-to-cart-sauce-labs-onesie";
    String add_to_cart_sauce__labs_fleece_jacketID = "add-to-cart-sauce-labs-fleece-jacket";

    /*
        Verifying items are available in cart.
     */
     String shoppingCartLinkID = "//a[@class='shopping_cart_link']";
     String yourCartTitleXpath = "//div[normalize-space()='Your Cart']";

     String firstItemXpath = "//div[normalize-space()='Sauce Labs Onesie']";
    String secondItemXpath = "//div[normalize-space()='Sauce Labs Fleece Jacket']";

}