package elior.com.infrastructure;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PlaceViewHolderFav extends RecyclerView.ViewHolder {

    public TextView name3, address3;
    public ImageView image3;
    public RelativeLayout relativeLayout3;

    public PlaceViewHolderFav(View itemView) {
        super(itemView);

        name3 = itemView.findViewById(R.id.name1);
        address3 = itemView.findViewById(R.id.address1);
        image3 = itemView.findViewById(R.id.image1);
        relativeLayout3 = itemView.findViewById(R.id.relative1);
    }
}