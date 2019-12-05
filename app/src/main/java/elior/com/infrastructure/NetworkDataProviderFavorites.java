package elior.com.infrastructure;

import android.os.AsyncTask;

import java.util.ArrayList;

import elior.com.infrastructure.DataAppPackage.PlaceModel;
import elior.com.infrastructure.RetrofitDagger2Package.MyApplication;
import elior.com.infrastructure.RoomFavoritesPackage.IPlacesDataReceived;
import elior.com.infrastructure.RoomFavoritesPackage.PlaceRepositoryFavorites;
import elior.com.infrastructure.RoomFavoritesPackage.PlacesFavorites;

public class NetworkDataProviderFavorites {

    public void getPlacesByLocation(IPlacesDataReceived resultListener_) {

        //go get data from google API
        // take time....
        //more time...
        //Data received -> resultListener_

        GetPlacesByLocationAsyncTask getPlacesByLocationAsyncTask = new GetPlacesByLocationAsyncTask(resultListener_);
        getPlacesByLocationAsyncTask.execute();
    }

    private class GetPlacesByLocationAsyncTask extends AsyncTask<String, Integer, IPlacesDataReceived> {

        private ArrayList<PlaceModel> mPlaceModels;
        private IPlacesDataReceived mIPlacesDataReceived;

        public GetPlacesByLocationAsyncTask(IPlacesDataReceived iPlacesDataReceived) {
            mIPlacesDataReceived = iPlacesDataReceived;
        }

        @Override
        protected IPlacesDataReceived doInBackground(String... urls) {
            mPlaceModels = new ArrayList<PlaceModel>();
            PlaceRepositoryFavorites placeRepository = new PlaceRepositoryFavorites(MyApplication.getApplication());
            ArrayList<PlacesFavorites> listPlaces = new ArrayList<>();
            for (PlaceModel placeModel : mPlaceModels) {
                try {
                    PlacesFavorites place = new PlacesFavorites(placeModel.getName(), placeModel.getVicinity(), placeModel.getPhotos().get(0).getPhoto_reference());
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
