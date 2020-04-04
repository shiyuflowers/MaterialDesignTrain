package shiyu.learn.materialdesigntrain;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private Context mContext;
    private List<Fruit> mFruitList;

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(mContext==null)
        {
            mContext=viewGroup.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.fruit_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Fruit fruit=mFruitList.get(i);
        viewHolder.mTextView_fruitName.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(viewHolder.mImageView_fruit);
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView mCardView;
        ImageView mImageView_fruit;
        TextView mTextView_fruitName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCardView=(CardView) itemView;
            mImageView_fruit=itemView.findViewById(R.id.imageView_fruit);
            mTextView_fruitName=itemView.findViewById(R.id.textView_fruitName);
        }
    }
}
