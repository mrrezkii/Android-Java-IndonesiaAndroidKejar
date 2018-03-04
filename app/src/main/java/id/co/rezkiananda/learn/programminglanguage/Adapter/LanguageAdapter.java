package id.co.rezkiananda.learn.programminglanguage.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.co.rezkiananda.learn.programminglanguage.Model.Language;
import id.co.rezkiananda.learn.programminglanguage.R;

/**
 * Created by Rezki on 2/21/2018.
 */

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {
    private final ArrayList<Language> languageList;
    iLanguageAdapter mLanguageAdapter;

    public LanguageAdapter(Context context, ArrayList<Language> languageList) {
        this.languageList = languageList;
        mLanguageAdapter = (iLanguageAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Language language = languageList.get(position);
        holder.tvJudul.setText(language.judul);
        holder.tvDeskripsi.setText(language.deskripsi);
        //holder.ivGambar.setImageDrawable(language.gambar);
        holder.ivGambar.setImageURI(Uri.parse(String.valueOf(language.gambar)));


    }

    @Override
    public int getItemCount() {
        if (languageList != null)
            return languageList.size();
        return 0;
    }

    public interface iLanguageAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGambar;
        TextView tvJudul, tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivGambar = itemView.findViewById(R.id.imageView);
            tvJudul = itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = itemView.findViewById(R.id.textViewDeskripsi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mLanguageAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
