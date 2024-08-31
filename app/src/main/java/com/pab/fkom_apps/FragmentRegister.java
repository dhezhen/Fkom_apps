package com.pab.fkom_apps;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentRegister extends Fragment {
    Button register;
    EditText username, email,password;
    public static final int REQUEST_CODE = 123;

    public FragmentRegister() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.register, container, false);

        username = view.findViewById(R.id.edtUsername);
        password = view.findViewById(R.id.edtPassword);
        email = view.findViewById(R.id.edtEmail);
        register = view.findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mendapatkan nilai dari EditText username dan password
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String emailValue = email.getText().toString();

                // Membuat intent untuk memulai aktivitas LoginDetails
                Intent intent = new Intent(getActivity(), RegisterDetail.class);
                // Menambahkan data ke intent
                intent.putExtra("username", usernameValue);
                intent.putExtra("email", emailValue);
                intent.putExtra("password", passwordValue);

                // Memulai aktivitas dengan intent, dengan permintaan kode
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        return view;
    }

    // Metode ini akan dipanggil saat hasil dikembalikan dari aktivitas yang dimulai dengan startActivityForResult()
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pastikan request code dan result code sesuai
        if (requestCode == REQUEST_CODE && resultCode == getActivity().RESULT_OK) {
            // Ambil data dari intent yang dikirimkan kembali dari aktivitas
            String resultData = data.getStringExtra("result");
            // Lakukan apa pun yang ingin Anda lakukan dengan data yang diterima
        }
    }
}
