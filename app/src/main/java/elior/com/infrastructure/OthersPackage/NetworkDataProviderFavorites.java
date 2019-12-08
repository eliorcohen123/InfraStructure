package elior.com.infrastructure.OthersPackage;

import android.os.AsyncTask;

import java.util.ArrayList;

import elior.com.infrastructure.ModelPackage.PlaceModel;
import elior.com.infrastructure.RetrofitDaggerPackage.MyApplication;
import elior.com.infrastructure.RoomFavoritesPackage.IPlacesDataReceived;
import elior.com.infrastructure.RoomFavoritesPackage.PlaceRepositoryFavorites;
import elior.com.infrastructure.RoomFavoritesPackage.PlacesFavorites;

public class NetworkDataProviderFavorites {

    public void getPlacesByLocation(IPlacesDataReceived resultListener_) {

        // go get data from google API
        // take time....
        // more time...
        // Data received -> resultListener_

        GetPlacesByLocationAsyncTask getPlacesByLocationAsyncTask = new GetPlacesByLocationAsyncTask(resultListener_);
        getPlacesByLocationAsyncTask.execute();
    }

    private class GetPlacesByLocationAsyncTask extends AsyncTask<String, Integer, IPlacesDataReceived> {

        private ArrayList<PlaceModel> mPlaceModels = new ArrayList<PlaceModel>();
        private ArrayList<PlacesFavorites> listPlaces = new ArrayList<PlacesFavorites>();
        private IPlacesDataReceived mIPlacesDataReceived;
        private PlaceRepositoryFavorites placeRepository;

        public GetPlacesByLocationAsyncTask(IPlacesDataReceived iPlacesDataReceived) {
            mIPlacesDataReceived = iPlacesDataReceived;
        }

        @Override
        protected IPlacesDataReceived doInBackground(String... urls) {
            placeRepository = new PlaceRepositoryFavorites(MyApplication.getApplication());
            for (PlaceModel placeModel : mPlaceModels) {
                try {
                    PlacesFavorites place = new PlacesFavorites(placeModel.getName(), placeModel.getVicinity(), placeModel.getPhotos());
                    listPlaces.add(place);
                } catch (Exception e) {

                }
            }

            placeRepository.insertPlace(listPlaces);

            return mIPlacesDataReceived;
        }

        @Override
        protected void onPostExecute(IPlacesDataReceived iPlacesDataReceived_) {
            try {
                iPlacesDataReceived_.onPlacesDataReceived(mPlaceModels);
            } catch (Exception e) {
                iPlacesDataReceived_.onPlacesDataReceived(mPlaceModels);
            }
        }
    }

}
