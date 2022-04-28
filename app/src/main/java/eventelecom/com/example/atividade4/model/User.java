package eventelecom.com.example.atividade4.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

public class User implements Parcelable {
    private int id;
    private String userName;
    private String name;
    private String email;
    private UserAddress userAddress;

    public User(int id, String userName, String name, String email, UserAddress userAddress) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.userAddress = userAddress;
    }

    protected User(Parcel in) {
        id = in.readInt();
        userName = in.readString();
        name = in.readString();
        email = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(userName, user.userName) && Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, name, email);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeString(getUserName());
        parcel.writeString(getName());
        parcel.writeString(getEmail());

    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
}