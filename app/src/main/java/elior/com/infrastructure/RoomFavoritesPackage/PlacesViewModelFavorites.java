package elior.com.infrastructure.RoomFavoritesPackage;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class PlacesViewModelFavorites extends AndroidViewModel {

    private PlacesRepositoryFavorites placesRepositoryFavorites;
    private LiveData<List<PlacesFavorites>> mAllPlacesFavorites;

    public PlacesViewModelFavorites(Application application) {
        super(application);

        placesRepositoryFavorites = new PlacesRepositoryFavorites(application);
        mAllPlacesFavorites = placesRepositoryFavorites.getAllPlaces();
    }

    public LiveData<List<PlacesFavorites>> getAllPlaces() {
        return mAllPlacesFavorites;
    }

    public void insertPlace(List<PlacesFavorites> placesFavorites) {
        placesRepositoryFavorites.insertPlace(placesFavorites);
    }

    public void deleteAll() {
        placesRepositoryFavorites.deleteLastSearch();
    }

    public void deletePlace(PlacesFavorites places) {
        placesRepositoryFavorites.deletePlace(places);
    }

    public void updatePlace(PlacesFavorites places) {
        placesRepositoryFavorites.updatePlace(places);
    }

}
