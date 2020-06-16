
package com.everacosta.misspets.models;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PetsResponseData implements Serializable, Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("found")
    @Expose
    private boolean found;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("__v")
    @Expose
    private int v;
    public final static Parcelable.Creator<PetsResponseData> CREATOR = new Creator<PetsResponseData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PetsResponseData createFromParcel(Parcel in) {
            return new PetsResponseData(in);
        }

        public PetsResponseData[] newArray(int size) {
            return (new PetsResponseData[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5021061229762120108L;

    protected PetsResponseData(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.owner = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.found = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((int) in.readValue((int.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public PetsResponseData() {
    }

    /**
     * 
     * @param owner
     * @param date
     * @param image
     * @param address
     * @param found
     * @param phone
     * @param v
     * @param name
     * @param description
     * @param id
     * @param type
     */
    public PetsResponseData(String id, String owner, String name, String type, String address, String phone, String date, String description, boolean found, String image, int v) {
        super();
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.type = type;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.description = description;
        this.found = found;
        this.image = image;
        this.v = v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PetsResponseData withId(String id) {
        this.id = id;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public PetsResponseData withOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetsResponseData withName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PetsResponseData withType(String type) {
        this.type = type;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PetsResponseData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PetsResponseData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PetsResponseData withDate(String date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PetsResponseData withDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public PetsResponseData withFound(boolean found) {
        this.found = found;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PetsResponseData withImage(String image) {
        this.image = image;
        return this;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public PetsResponseData withV(int v) {
        this.v = v;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(owner);
        dest.writeValue(name);
        dest.writeValue(type);
        dest.writeValue(address);
        dest.writeValue(phone);
        dest.writeValue(date);
        dest.writeValue(description);
        dest.writeValue(found);
        dest.writeValue(image);
        dest.writeValue(v);
    }

    public int describeContents() {
        return  0;
    }

}
