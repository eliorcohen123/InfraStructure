package elior.com.infrastructure.RoomFavoritesPackage;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "places_table_favorites", indices = @Index(value = {"name"}, unique = true))
public class PlacesFavorites implements Serializable {

    public PlacesFavorites(@NonNull String mName, @NonNull String mAddress, String mPhoto) {
        this.mName = mName;
        this.mAddress = mAddress;
        this.mPhoto = mPhoto;
    }

    public PlacesFavorites() {

    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long ID;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "address")
    private String mAddress;

    @ColumnInfo(name = "photo")
    private String mPhoto;


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    public void setName(@NonNull String mName) {
        this.mName = mName;
    }

    @NonNull
    public String getAddress() {
        return mAddress;
    }

    public void setAddress(@NonNull String mAddress) {
        this.mAddress = mAddress;
    }

    public String getPhoto() {
        return mPhoto;
    }

    public void setPhoto(String mPhoto) {
        this.mPhoto = mPhoto;
    }

}
