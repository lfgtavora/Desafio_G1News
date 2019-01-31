package com.example.g1news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.g1news.models.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.CardHolder> {

    private List<News> items = new ArrayList<>();
    private Context context;

    public NewsAdapter(List<News> items, Context context) {
        this.items = items;
        this.context = context;
    }

    public void setItems(List<News> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        return new CardHolder(itemList);
    }

    @Override

    public void onBindViewHolder(@NonNull CardHolder cardHolder, int i) {

        News item = items.get(i);

        cardHolder.title.setText(item.getContent().getTitle());
        cardHolder.summary.setText(item.getContent().getSummary());
        try{
            Picasso.get().load(item.getContent().getImage().getSizes().getL().getUrl()).into(cardHolder.thumbnail);
        } catch (Exception e){
            cardHolder.thumbnail.setImageResource(R.drawable.generic_thumb);
        }
        cardHolder.category.setText(item.getContent().getSection());
        cardHolder.date.setText(cardHolder.timeAgo(item.getAge()));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CardHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView category;
        private ImageView thumbnail;
        private TextView summary;
        private TextView date;

        public CardHolder(@NonNull View itemView) {
            super(itemView);

            title =     itemView.findViewById(R.id.Title);
            category  = itemView.findViewById(R.id.Category);
            thumbnail = itemView.findViewById(R.id.Thumbnail);
            summary =   itemView.findViewById(R.id.Summary);
            date =      itemView.findViewById(R.id.Time);

        }

        public String timeAgo(String age){
            long seconds = Long.valueOf(age);
            int day = (int) TimeUnit.SECONDS.toDays(seconds);
            long hours = TimeUnit.SECONDS.toHours(seconds) -
                    TimeUnit.DAYS.toHours(day);
            long minute = TimeUnit.SECONDS.toMinutes(seconds) -
                    TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(seconds));
            long second = TimeUnit.SECONDS.toSeconds(seconds) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(seconds));

            if (day == 1)
                return day + " dia atrás";
            else if (day > 1)
                return day + " dias atrás";

            if (hours == 1)
                return hours + " hora atrás";
            else if (hours > 1)
                return hours + " horas atrás";

            if (minute == 1)
                return minute + " minuto atrás";
            else if (minute > 1)
                return minute + " minutos atrás";
            else
                return null;
        }

    }
}
