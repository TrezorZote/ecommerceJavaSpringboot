package com.Worker.worker;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Worker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String productCategory;
    private Long contact;
    private String productLocation;
    @Lob
    private byte[] imageUrl;
    @Lob
    private byte[] mainImage1;
    @Lob
    private byte[] mainImage2;
    @Lob
    private byte[] mainImage3;
    @Lob
    private byte[] mainImage4;
    private String productDescription;
    private Long productPassWord;
    private Long productPrice;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private String ipAddress;



    public Worker() {
    }


    public Worker(String ipAddress,
                  String productCategory,
                  Long contact,
                  String productLocation,
                  byte[] imageUrl,byte[] mainImage1,byte[] mainImage2,
                  byte[] mainImage3,byte[] mainImage4,String productDescription,
                  Long productPassWord,
                  Long productPrice


    ) {

        this.ipAddress = ipAddress;
        this.imageUrl=  imageUrl;
        this.mainImage1=  mainImage1;
        this.mainImage2=  mainImage2;
        this.mainImage3=  mainImage3;
        this.mainImage4=  mainImage4;
        this.productPassWord=productPassWord;
        this.productPrice=productPrice;
        this.productDescription=productDescription;
        this.contact=contact;
        this.productCategory=productCategory;
        this.productLocation= productLocation;
        }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public byte[] getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(byte[] imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getProductPassWord() {
        return productPassWord;
    }
    public void setProductPassWord(Long productPassWord) {
        this.productPassWord = productPassWord;
    }

    public String getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Long getContact() {
        return contact;
    }
    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    public Long getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductLocation() {
        return productLocation;
    }
    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;
    }



    @Override
    public String toString(){
        return "Worker{"+
                "id=" +id +
                " ,ipAddress=" + ipAddress+
                " ,mainImage="+imageUrl+
                " ,itemPassword=" + productPassWord +" ,itemDescription=" + productDescription +
                " ,price=" + productPrice +" ,contact=" + contact +" ,sellerName=" + productCategory +
                " ,itemLocation=" + productLocation +
                "}";
    }



    public byte[] getMainImage1() {
        return mainImage1;
    }

    public void setMainImage1(byte[] mainImage1) {
        this.mainImage1 = mainImage1;
    }

    public byte[] getMainImage2() {
        return mainImage2;
    }

    public void setMainImage2(byte[] mainImage2) {
        this.mainImage2 = mainImage2;
    }

    public byte[] getMainImage3() {
        return mainImage3;
    }

    public void setMainImage3(byte[] mainImage3) {
        this.mainImage3 = mainImage3;
    }

    public byte[] getMainImage4() {
        return mainImage4;
    }

    public void setMainImage4(byte[] mainImage4) {
        this.mainImage4 = mainImage4;
    }
}
