package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class tambah_data extends AppCompatActivity {
    private EditText etid;
    private EditText etnama;
    private EditText etkode;
    private EditText etjenis;
    private Button btn_tambah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        etnama = findViewById(R.id.nama);
        etkode = findViewById(R.id.kode);
        etjenis = findViewById(R.id.jenis);

        btn_tambah = findViewById(R.id.btn_tambah);
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etnama.getText().toString();
                String kode = etkode.getText().toString();
                String jenis = etjenis.getText().toString();


                if (nama.isEmpty()){
                    Toast.makeText(tambah_data.this, "Nama Barang Harus Di Isi", Toast.LENGTH_SHORT).show();

                }
                if (kode.isEmpty()){
                    Toast.makeText(tambah_data.this, "Kode Barang Harus Di Isi", Toast.LENGTH_SHORT).show();
                }
                if (jenis.isEmpty()){
                    Toast.makeText(tambah_data.this, "Jenis Barang Harus Di Isi", Toast.LENGTH_SHORT).show();

                }
                AndroidNetworking.post(BaseURL.url+"insert.php")
                        .addBodyParameter("nama", nama)
                        .addBodyParameter("kode", kode)
                        .addBodyParameter("jenis", jenis)
                        .setPriority(Priority.LOW)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONObject hasil = response.getJSONObject("hasil");
                                    boolean sukses = hasil.getBoolean("respon");
                                    if (sukses){
                                        Intent returnIntent = new Intent();
                                        returnIntent.putExtra("refresh", "refresh");
                                        setResult(23, returnIntent);
                                        finish();
                                        Toast.makeText(tambah_data.this, "Tambah Barang Sukses", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(tambah_data.this, "Tambah Barang Gagal", Toast.LENGTH_SHORT).show();
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                    System.out.println("pppp" + e.getMessage());
                                    Toast.makeText(tambah_data.this, "Tambah Barang Fail", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                System.out.println("ttttt" + anError);
                                System.out.println("ttttt" + anError.getErrorBody());
                                System.out.println("ttttt" + anError.getErrorDetail());
                                System.out.println("ttttt" + anError.getResponse());
                                System.out.println("ttttt" + anError.getErrorCode());

                                Toast.makeText(tambah_data.this, "Tambah Data Gagal", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
