package com.bayufajariyanto.recyclerview;

public class Contact {
    private String name, phone, imageUrl;

    public Contact(String name, String phone, String imageUrl){
        this.name = name;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
