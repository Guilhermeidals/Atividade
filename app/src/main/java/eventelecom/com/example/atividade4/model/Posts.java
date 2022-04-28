package eventelecom.com.example.atividade4.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

public class Posts implements Parcelable {
    private int id;
    private String title;
    private String post;
    private int userId;

    public Posts(int id, String title, String post, int userId) {
        this.id = id;
        this.title = title;
        this.post = post;
        this.userId = userId;
    }

    protected Posts(Parcel in) {
        id = in.readInt();
        title = in.readString();
        post = in.readString();
        userId = in.readInt();
    }

    public static final Creator<Posts> CREATOR = new Creator<Posts>() {
        @Override
        public Posts createFromParcel(Parcel in) {
            return new Posts(in);
        }
        @Override
        public Posts[] newArray(int size) {
            return new Posts[size];
        }
    };

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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Posts post = (Posts) o;
        return id == post.id && Objects.equals(title, post.title) && Objects.equals(post,post.post) && Objects.equals(userId, post.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,title, post, userId);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeString(getTitle());
        parcel.writeString(getPost());
        parcel.writeInt(getUserId());
    }
}
