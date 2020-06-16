
package com.everacosta.misspets.models;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProfileResponseData implements Serializable, Parcelable
{

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<GetProfileResponseData> CREATOR = new Creator<GetProfileResponseData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GetProfileResponseData createFromParcel(Parcel in) {
            return new GetProfileResponseData(in);
        }

        public GetProfileResponseData[] newArray(int size) {
            return (new GetProfileResponseData[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3507307045834948333L;

    protected GetProfileResponseData(Parcel in) {
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.lastname = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetProfileResponseData() {
    }

    /**
     * 
     * @param name
     * @param email
     * @param lastname
     */
    public GetProfileResponseData(String email, String lastname, String name) {
        super();
        this.email = email;
        this.lastname = lastname;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GetProfileResponseData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public GetProfileResponseData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GetProfileResponseData withName(String name) {
        this.name = name;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(email);
        dest.writeValue(lastname);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
