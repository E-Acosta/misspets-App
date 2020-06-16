
package com.everacosta.misspets.models;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProfileResponse implements Serializable, Parcelable
{

    @SerializedName("error")
    @Expose
    private boolean error;
    @SerializedName("data")
    @Expose
    private GetProfileResponseData getProfileResponseData;
    public final static Parcelable.Creator<GetProfileResponse> CREATOR = new Creator<GetProfileResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GetProfileResponse createFromParcel(Parcel in) {
            return new GetProfileResponse(in);
        }

        public GetProfileResponse[] newArray(int size) {
            return (new GetProfileResponse[size]);
        }

    }
    ;
    private final static long serialVersionUID = 471883455618195044L;

    protected GetProfileResponse(Parcel in) {
        this.error = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.getProfileResponseData = ((GetProfileResponseData) in.readValue((GetProfileResponseData.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetProfileResponse() {
    }

    /**
     * 
     * @param getProfileResponseData
     * @param error
     */
    public GetProfileResponse(boolean error, GetProfileResponseData getProfileResponseData) {
        super();
        this.error = error;
        this.getProfileResponseData = getProfileResponseData;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public GetProfileResponse withError(boolean error) {
        this.error = error;
        return this;
    }

    public GetProfileResponseData getGetProfileResponseData() {
        return getProfileResponseData;
    }

    public void setGetProfileResponseData(GetProfileResponseData getProfileResponseData) {
        this.getProfileResponseData = getProfileResponseData;
    }

    public GetProfileResponse withData(GetProfileResponseData getProfileResponseData) {
        this.getProfileResponseData = getProfileResponseData;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(getProfileResponseData);
    }

    public int describeContents() {
        return  0;
    }

}
