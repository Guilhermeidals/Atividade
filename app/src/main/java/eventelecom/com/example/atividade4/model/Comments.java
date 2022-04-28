package eventelecom.com.example.atividade4.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

public class Comments implements Parcelable {
    private int id;
    private int postUserId;
    private String name;
    private String email;
    private String comment;

    public Comments(int id, int postUserId, String name, String email, String comment) {
        this.id = id;
        this.postUserId = postUserId;
        this.name = name;
        this.email = email;
        this.comment = comment;
    }

    protected Comments(Parcel in) {
        id = in.readInt();
        postUserId = in.readInt();
        name = in.readString();
        email = in.readString();
        comment = in.readString();
    }

    public static final Creator<Comments> CREATOR = new Creator<Comments>() {
        @Override
        public Comments createFromParcel(Parcel in) {
            return new Comments(in);
        }
        @Override
        public Comments[] newArray(int size) {
            return new Comments[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(int postUserId) {
        this.postUserId = postUserId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Comments com = (Comments) o;
        return id == com.id && Objects.equals(postUserId, com.postUserId) && Objects.equals(name,com.name) && Objects.equals(comment, com.comment) && Objects.equals(email, com.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name, email, comment, postUserId);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeString(getName());
        parcel.writeString(getEmail());
        parcel.writeString(getComment());
        parcel.writeInt(getPostUserId());
    }



}