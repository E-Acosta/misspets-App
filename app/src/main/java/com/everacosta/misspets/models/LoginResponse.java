
package com.everacosta.misspets.models;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse implements Serializable, Parcelable
{

    @SerializedName("error")
    @Expose
    private boolean error;
    @SerializedName("data")
    @Expose
    private LoginResponseData loginResponseData;
    public final static Parcelable.Creator<LoginResponse> CREATOR = new Creator<LoginResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LoginResponse createFromParcel(Parcel in) {
            return new LoginResponse(in);
        }

        public LoginResponse[] newArray(int size) {
            return (new LoginResponse[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4506697421291260874L;

    protected LoginResponse(Parcel in) {
        this.error = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.loginResponseData = ((LoginResponseData) in.readValue((LoginResponseData.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginResponse() {
    }

    /**
     * 
     * @param loginResponseData
     * @param error
     */
    public LoginResponse(boolean error, LoginResponseData loginResponseData) {
        super();
        this.error = error;
        this.loginResponseData = loginResponseData;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public LoginResponse withError(boolean error) {
        this.error = error;
        return this;
    }

    public LoginResponseData getLoginResponseData() {
        return loginResponseData;
    }

    public void setLoginResponseData(LoginResponseData loginResponseData) {
        this.loginResponseData = loginResponseData;
    }

    public LoginResponse withData(LoginResponseData loginResponseData) {
        this.loginResponseData = loginResponseData;
        return this;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "error=" + error +
                ", loginResponseData=" + loginResponseData +
                '}';
    }

    @Override


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(loginResponseData);
    }

    public int describeContents() {
        return  0;
    }

}
