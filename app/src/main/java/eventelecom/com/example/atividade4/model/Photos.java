package eventelecom.com.example.atividade4.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Photos implements Parcelable {
        private int albumId;
        private int id;
        private String title;
        private String url;
        private String thumbnailUrl;

        public Photos(int albumId,int id, String title, String url, String thumbnailUrl){
                this.albumId = albumId;
                this.id = id;
                this.title = title;
                this.url = url;
                this.thumbnailUrl = thumbnailUrl;
        }

        protected Photos(Parcel in) {
                albumId = in.readInt();
                id = in.readInt();
                title = in.readString();
                url = in.readString();
                thumbnailUrl = in.readString();
        }

        public static final Creator<Photos> CREATOR = new Creator<Photos>() {
                @Override
                public Photos createFromParcel(Parcel in) {
                        return new Photos(in);
                }
                @Override
                public Photos[] newArray(int size) {
                        return new Photos[size];
                }
        };

        public int getAlbumId() {
                return albumId;
        }

        public void setAlbumId(int albumId) {
                this.albumId = albumId;
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

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public String getThumbnailUrl() {
                return thumbnailUrl;
        }

        public void setThumbnailUrl(String thumbnailUrl) {
                this.thumbnailUrl = thumbnailUrl;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Photos)) return false;
                Photos photos = (Photos) o;
                return albumId == photos.albumId && id == photos.id && Objects.equals(title, photos.title) && Objects.equals(url, photos.url) && Objects.equals(thumbnailUrl, photos.thumbnailUrl);
        }

        @Override
        public int hashCode() {
                return Objects.hash(albumId, id, title, url, thumbnailUrl);
        }

        @Override
        public int describeContents() {
                return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(albumId);
                parcel.writeInt(id);
                parcel.writeString(title);
                parcel.writeString(url);
                parcel.writeString(thumbnailUrl);
        }
}
