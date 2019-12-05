package elior.com.infrastructure.RoomFavoritesPackage;

import java.util.ArrayList;

import elior.com.infrastructure.DataAppPackage.PlaceModel;

public interface IPlacesDataReceived {

    void onPlacesDataReceived(ArrayList<PlaceModel> results_);
}
