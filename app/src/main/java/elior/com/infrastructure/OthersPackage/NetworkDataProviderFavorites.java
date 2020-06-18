package elior.com.infrastructure.OthersPackage;

import android.os.AsyncTask;

import java.util.ArrayList;

import elior.com.infrastructure.ModelPackage.PlaceModel;
import elior.com.infrastructure.RetrofitDaggerPackage.MyApplication;
import elior.com.infrastructure.RoomFavoritesPackage.PlaceViewModelFavorites;
import elior.com.infrastructure.RoomFavoritesPackage.PlacesFavorites;

public class NetworkDataProviderFavorites {

    public void getPlacesByLocation() {

        // go get data from google API
        // take time....
        // more time...
        // Data received -> resultListener_

        GetPlacesByLocationAsyncTask getPlacesByLocationAsyncTask = new GetPlacesByLocationAsyncTask();
        getPlacesByLocationAsyncTask.execute();
    }

    private static class GetPlacesByLocationAsyncTask extends AsyncTask<String, Integer, ArrayList<PlaceModel>> {

        private ArrayList<PlaceModel> mPlaceModels = new ArrayList<PlaceModel>();
        private ArrayList<PlacesFavorites> listPlaces = new ArrayList<PlacesFavorites>();
        private PlaceViewModelFavorites placeViewModelFavorites;

        public GetPlacesByLocationAsyncTask() {

        }

        @Override
        protected ArrayList<PlaceModel> doInBackground(String... urls) {
            placeViewModelFavorites = new PlaceViewModelFavorites(MyApplication.getApplication());
            for (PlaceModel placeModel : mPlaceModels) {
                try {
                    PlacesFavorites place = new PlacesFavorites(placeModel.getName(), placeModel.getVicinity(), placeModel.getPhotos());
                    listPlaces.add(place);
                } catch (Exception e) {

                }
            }

            placeViewModelFavorites.insertPlace(listPlaces);

            return mPlaceModels;
        }

        @Override
        protected void onPostExecute(ArrayList<PlaceModel> arrayList) {

        }
    }

}
