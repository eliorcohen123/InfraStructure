package elior.com.infrastructure;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import elior.com.infrastructure.DataAppPackage.PlaceModel;
import elior.com.infrastructure.RetrofitDagger2Package.MyApplication;
import elior.com.infrastructure.RoomFavoritesPackage.PlaceRepositoryFavorites;
import elior.com.infrastructure.RoomFavoritesPackage.PlaceViewModelFavorites;
import elior.com.infrastructure.RoomFavoritesPackage.PlacesFavorites;

public class PlacesListAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    private final LayoutInflater mInflater;
    private List<PlaceModel> mPlacesSearchList;
    private PlaceModel current;
    private PlaceViewModelFavorites placeViewModelSearch;

    public PlacesListAdapter(Context context, List<PlaceModel> placesSearchList) {
        mInflater = LayoutInflater.from(context);
        this.mPlacesSearchList = placesSearchList;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item_total, parent, false);
        return new PlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PlaceViewHolder holder, final int position) {
        if (mPlacesSearchList != null) {
            current = mPlacesSearchList.get(position);
            holder.name1.setText(current.getName());
            holder.address1.setText(current.getVicinity());
            try {
                Glide.with(mInflater.getContext())
                        .load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="
                                + current.getPhotos() +
                                "&key=" + mInflater.getContext().getString(R.string.api_key_search))
                        .into(holder.image1);
            } catch (Exception e) {

            }

            PlaceRepositoryFavorites placeRepositorySearch = new PlaceRepositoryFavorites(MyApplication.getApplication());
            ArrayList<PlacesFavorites> listPlaces = new ArrayList<>();
            for (PlaceModel placeModel : mPlacesSearchList) {
                try {
                    PlacesFavorites place = new PlacesFavorites(placeModel.getName(), placeModel.getVicinity(), placeModel.getPhotos().get(0).getPhoto_reference());
                    listPlaces.add(place);
                } catch (Exception e) {

                }
            }
            placeViewModelSearch = new PlaceViewModelFavorites(MyApplication.getApplication());
            placeViewModelSearch.deleteAll();
            placeRepositorySearch.insertPlace(listPlaces);

            holder.relativeLayout1.setOnClickListener(v -> {
                Intent intent = new Intent(mInflater.getContext(), FavoritesPlaces.class);
                mInflater.getContext().startActivity(intent);
            });
        } else {
            // Covers the case of data not being ready yet.
            holder.name1.setText("No Places");
        }
    }

    // getItemCount() is called many times, and when it is first called,
    // mPlacesSearchList has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mPlacesSearchList != null)
            return mPlacesSearchList.size();
        else return 0;
    }

}
