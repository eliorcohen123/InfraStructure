package elior.com.infrastructure.OthersPackage;

import android.os.AsyncTask;

import java.util.ArrayList;

import elior.com.infrastructure.RetrofitDaggerPackage.MyApplication;
import elior.com.infrastructure.RoomFavoritesPackage.PlacesFavorites;
import elior.com.infrastructure.RoomFavoritesPackage.PlacesViewModelFavorites;

public class NetworkDataProviderFavorites {

    public void getPlacesByLocation() {

        // go get data from google API
        // take time....
        // more time...
        // Data received -> resultListener_

        GetPlacesByLocationAsyncTask getPlacesByLocationAsyncTask = new GetPlacesByLocationAsyncTask();
        getPlacesByLocationAsyncTask.execute();
    }

    private static class GetPlacesByLocationAsyncTask extends AsyncTask<Void, Integer, ArrayList<PlacesFavorites>> {

        private ArrayList<PlacesFavorites> listPlaces = new ArrayList<PlacesFavorites>();
        private PlacesViewModelFavorites placeViewModelFavorites;

        @Override
        protected ArrayList<PlacesFavorites> doInBackground(Void... voids) {
            placeViewModelFavorites = new PlacesViewModelFavorites(MyApplication.getApplication());
            for (PlacesFavorites placeModel : listPlaces) {
                try {
                    PlacesFavorites place = new PlacesFavorites(placeModel.getName(), placeModel.getAddress(), placeModel.getPhoto());
                    listPlaces.add(place);
                } catch (Exception e) {

                }
            }

            placeViewModelFavorites.insertPlace(listPlaces);

            return listPlaces;
        }

        @Override
        protected void onPostExecute(ArrayList<PlacesFavorites> arrayList) {

        }
    }

}
