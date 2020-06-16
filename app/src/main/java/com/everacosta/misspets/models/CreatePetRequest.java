package com.everacosta.misspets.models;

public class CreatePetRequest {
    String name;
    String type;
    String address;
    String phone;
    String date;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreatePetRequest(String name, String type, String address, String phone, String date, String description) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return "CreatePetRequest{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public CreatePetRequest() {
    }
//    {
//        "name":"Sr Bigote",
//            "type":"cat",
//            "address":"Calle 4b5#3s-61",
//            "phone":"+573226274440",
//            "date":"15/08/2020",
//            "description":"Usualmente salia por las noches, una noche no regresó"
//    }
}
