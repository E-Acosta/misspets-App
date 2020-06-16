
package com.everacosta.misspets.models;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateUserResponse implements Serializable, Parcelable
{

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("userRegistered")
    @Expose
    private boolean userRegistered;
    public final static Parcelable.Creator<CreateUserResponse> CREATOR = new Creator<CreateUserResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CreateUserResponse createFromParcel(Parcel in) {
            return new CreateUserResponse(in);
        }

        public CreateUserResponse[] newArray(int size) {
            return (new CreateUserResponse[size]);
        }

    }
    ;
    private final static long serialVersionUID = 734540461179966719L;

    protected CreateUserResponse(Parcel in) {
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.userRegistered = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public CreateUserResponse() {
    }

    /**
     * 
     * @param message
     * @param userRegistered
     */
    public CreateUserResponse(String message, boolean userRegistered) {
        super();
        this.message = message;
        this.userRegistered = userRegistered;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CreateUserResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean isUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(boolean userRegistered) {
        this.userRegistered = userRegistered;
    }

    public CreateUserResponse withUserRegistered(boolean userRegistered) {
        this.userRegistered = userRegistered;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(message);
        dest.writeValue(userRegistered);
    }

    public int describeContents() {
        return  0;
    }

}
