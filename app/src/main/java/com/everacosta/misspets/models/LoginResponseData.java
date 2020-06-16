
package com.everacosta.misspets.models;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponseData implements Serializable, Parcelable
{

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("token")
    @Expose
    private String token;
    public final static Parcelable.Creator<LoginResponseData> CREATOR = new Creator<LoginResponseData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LoginResponseData createFromParcel(Parcel in) {
            return new LoginResponseData(in);
        }

        public LoginResponseData[] newArray(int size) {
            return (new LoginResponseData[size]);
        }

    }
    ;
    private final static long serialVersionUID = 6953833630438567426L;

    protected LoginResponseData(Parcel in) {
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.token = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginResponseData() {
    }

    /**
     * 
     * @param message
     * @param token
     */
    public LoginResponseData(String message, String token) {
        super();
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginResponseData withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponseData withToken(String token) {
        this.token = token;
        return this;
    }

    @Override
    public String toString() {
        return "LoginResponseData{" +
                "message='" + message + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    @Override


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(message);
        dest.writeValue(token);
    }

    public int describeContents() {
        return  0;
    }

}
