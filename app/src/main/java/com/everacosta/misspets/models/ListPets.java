
package com.everacosta.misspets.models;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListPets implements Serializable, Parcelable
{

    @SerializedName("error")
    @Expose
    private boolean error;
    @SerializedName("data")
    @Expose
    private List<PetsResponseData> data = null;
    public final static Parcelable.Creator<ListPets> CREATOR = new Creator<ListPets>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ListPets createFromParcel(Parcel in) {
            return new ListPets(in);
        }

        public ListPets[] newArray(int size) {
            return (new ListPets[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8514488990104696128L;

    protected ListPets(Parcel in) {
        this.error = ((boolean) in.readValue((boolean.class.getClassLoader())));
        in.readList(this.data, (PetsResponseData.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListPets() {
    }

    /**
     * 
     * @param data
     * @param error
     */
    public ListPets(boolean error, List<PetsResponseData> data) {
        super();
        this.error = error;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ListPets withError(boolean error) {
        this.error = error;
        return this;
    }

    public List<PetsResponseData> getData() {
        return data;
    }

    public void setData(List<PetsResponseData> data) {
        this.data = data;
    }

    public ListPets withData(List<PetsResponseData> data) {
        this.data = data;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeList(data);
    }

    public int describeContents() {
        return  0;
    }

}
