package com.example.login;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
    private ArrayList<model> dataList;
    private Callback callback;


    interface Callback {
        void onClick(int position);
        void test();
    }


    public MahasiswaAdapter(ArrayList<model> dataList, Callback callback) {
        this.callback = callback;
        this.dataList = dataList;
    }

    @Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MahasiswaViewHolder holder, final int position) {
        holder.txtNama.setText(dataList.get(position).getId()+" , "+dataList.get(position).getNama());
        holder.txtKode.setText(dataList.get(position).getKode());
        holder.txtJenis.setText(dataList.get(position).getJenis());
//        holder.card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(holder.itemView.getContext(), ""+position, Toast.LENGTH_SHORT).show();
//                Intent in =new Intent(holder.itemView.getContext().getApplicationContext(), EditData.class);
//                in.putExtra("id",dataList.get(position).getId());
//                in.putExtra("nama",dataList.get(position).getNama());
//                in.putExtra("pesanan",dataList.get(position).getPesanan());
//                in.putExtra("no-hp",dataList.get(position).getNo_hp());
//                in.putExtra("alamat",dataList.get(position).getAlamat());
//                holder.itemView.getContext().startActivity(in);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtKode, txtJenis;
        CardView card;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.cardku);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_barang);
            txtKode = (TextView) itemView.findViewById(R.id.txt_kode_barang);
            txtJenis = (TextView) itemView.findViewById(R.id.txt_jenis_barang);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }
            });
        }
    }

}
