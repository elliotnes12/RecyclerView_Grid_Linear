package mx.unpoco.todo.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> data;
    private int layout;
    private OnItemClickListener itemClickListener;

    public MyAdapter(List<String> data, int layout, OnItemClickListener itemClickListener) {
        this.data = data;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
        MyViewHolder vh = new MyViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
             myViewHolder.bind(data.get(i),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public MyViewHolder(View view) {

            super(view);
            mTextView = (TextView) view.findViewById(R.id.texto);
        }
        public void bind(final String name,final OnItemClickListener listener ){

            this.mTextView.setText("Valor::"+name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(name,getAdapterPosition());
                }
            });
        }
    }
    public interface OnItemClickListener{
        void OnItemClick(String valor,int posicion);
    }

}
