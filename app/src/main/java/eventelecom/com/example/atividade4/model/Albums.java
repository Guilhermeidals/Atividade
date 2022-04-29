package eventelecom.com.example.atividade4.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Albums implements Parcelable {
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int userId;
    private int id;
    private String title;

    public Albums(int userId, int id, String title){
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    protected Albums(Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
    }

    public static final Creator<Albums> CREATOR = new Creator<Albums>() {
        @Override
        public Albums createFromParcel(Parcel in) {
            return new Albums(in);
        }

        @Override
        public Albums[] newArray(int size) {
            return new Albums[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Albums)) return false;
        Albums albums = (Albums) o;
        return userId == albums.userId && id == albums.id && Objects.equals(title, albums.title);
    }

    @Override
    public int hashCode(){
        return Objects.hash(userId,id,title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(userId);
        parcel.writeInt(id);
        parcel.writeString(title);
    }
}
