package elior.com.infrastructure.AdapterPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import elior.com.infrastructure.R;
import elior.com.infrastructure.RoomFavoritesPackage.PlacesFavorites;

public class PlacesListAdapterFav extends RecyclerView.Adapter<PlaceViewHolderFav> {

    private final LayoutInflater mInflater;
    private List<PlacesFavorites> mPlacesFavoritesList;
    private PlacesFavorites current;

    public PlacesListAdapterFav(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public PlaceViewHolderFav onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item_total, parent, false);
        return new PlaceViewHolderFav(itemView);
    }

    @Override
    public void onBindViewHolder(final PlaceViewHolderFav holder, final int position) {
        if (mPlacesFavoritesList != null) {
            current = mPlacesFavoritesList.get(position);
            holder.name1.setText(current.getName());
            holder.address1.setText(current.getAddress());
            Glide.with(mInflater.getContext())
                    .load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="
                            + current.getPhoto() +
                            "&key=" + mInflater.getContext().getString(R.string.api_key_search))
                    .into(holder.image1);
            holder.relativeLayout1.setOnClickListener(v -> {

            });

        } else {
            // Covers the case of data not being ready yet.
            holder.name1.setText("No Places");
        }
    }

    public void setPlaces(List<PlacesFavorites> placesFavorites) {
        mPlacesFavoritesList = placesFavorites;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mPlacesSearchList has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mPlacesFavoritesList != null)
            return mPlacesFavoritesList.size();
        else return 0;
    }

    public PlacesFavorites getPlaceAtPosition(int position) {
        return mPlacesFavoritesList.get(position);
    }

}
