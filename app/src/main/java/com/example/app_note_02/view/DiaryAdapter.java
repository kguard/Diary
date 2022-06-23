package com.example.app_note_02.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_note_02.R;
import com.example.app_note_02.model.Database.Diary;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder> {
    private List<Diary> diaryList;
    Context mContext;

    public DiaryAdapter(List<Diary> list, Context context) {
        diaryList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.itemholder, parent, false);
        DiaryAdapter.ViewHolder viewholder = new DiaryAdapter.ViewHolder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Diary item = diaryList.get(position);
        holder.title.setText(item.title);
    }

    @Override
    public int getItemCount() {
        return diaryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titletextview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    int pos = getAdapterPosition();
                    Diary item = diaryList.get(pos);
                    intent.putExtra("id",item.id);
                    intent.putExtra("title",item.title);
                    intent.putExtra("content",item.content);
                    mContext.startActivity(intent);
                    ((MainActivity)mContext).finish();
                }
            });
        }
    }

}
