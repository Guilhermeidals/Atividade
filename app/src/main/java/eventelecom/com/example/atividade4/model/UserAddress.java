package eventelecom.com.example.atividade4.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserAddress implements Parcelable {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    public UserAddress(String street, String suite, String city, String zipcode){
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
    }


    protected UserAddress(Parcel in) {
        street = in.readString();
        suite = in.readString();
        city = in.readString();
        zipcode = in.readString();
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public static final Creator<UserAddress> CREATOR = new Creator<UserAddress>() {
        @Override
        public UserAddress createFromParcel(Parcel in) {
            return new UserAddress(in);
        }

        @Override
        public UserAddress[] newArray(int size) {
            return new UserAddress[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(street);
        parcel.writeString(suite);
        parcel.writeString(city);
        parcel.writeString(zipcode);
    }
}
