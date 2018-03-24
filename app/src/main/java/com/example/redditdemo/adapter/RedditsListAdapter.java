package com.example.redditdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.redditdemo.R;
import com.example.redditdemo.model.PopularRedditsResponse;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RedditsListAdapter extends RecyclerView.Adapter<RedditsListAdapter.ItemViewHolder> {
    private final Context context;
    private final List<PopularRedditsResponse.DataBeanX.ChildrenBean> redditsList;
    private final LayoutInflater inflater;
    private RecyclerViewItemClick itemClick;

    public RedditsListAdapter(Context context, List<PopularRedditsResponse.DataBeanX
            .ChildrenBean> redditsList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.redditsList = redditsList;
    }

    public void setItemClick(RecyclerViewItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(inflater.inflate(R.layout.reddit_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(redditsList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return redditsList.size();
    }

    public PopularRedditsResponse.DataBeanX.ChildrenBean getItemAt(int position) {
        return redditsList.get(position);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements
            IViewHolderBinder<PopularRedditsResponse.DataBeanX.ChildrenBean> {


        @BindView(R.id.ivImg)
        ImageView ivImg;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.cardAuthor)
        TextView cardAuthor;
        @BindView(R.id.cardUpdated)
        TextView cardUpdated;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (itemClick != null) {
                    itemClick.onItemClicked(RedditsListAdapter.this, this, getLayoutPosition());
                }
            });
        }

        @Override
        public void bind(PopularRedditsResponse.DataBeanX.ChildrenBean data, int position) {
            //get the persons information
            String title = data.getData().getTitle();
            String imgUrl = data.getData().getIcon_img();
            String author = data.getData().getName();
            String date_updated = data.getData().getDisplay_name();

            tvTitle.setText(title);
            ImageLoader.getInstance().displayImage(imgUrl, ivImg);
            cardAuthor.setText(author);
            cardUpdated.setText(date_updated);

        }
    }
}
