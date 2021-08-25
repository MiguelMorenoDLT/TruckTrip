package co.edu.unipiloto.application;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et_Name, et_LastName, et_Id, et_Phone, et_Email, et_Address;
    private Spinner et_userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_userId = findViewById(R.id.type);
        et_Name = (EditText)findViewById(R.id.txt_FirstName);
        et_LastName = (EditText)findViewById(R.id.txt_LastName);
        et_Id = (EditText)findViewById(R.id.txt_Id);
        et_Phone = (EditText)findViewById(R.id.txt_Phone);
        et_Email = (EditText)findViewById(R.id.txt_Email);
        et_Address = (EditText)findViewById(R.id.txt_Address);
    }

    public void Registrar(View view){
        DataBase datos = new DataBase(this, "baseDatos", null, 1);
        SQLiteDatabase BaseDeDatos = datos.getWritableDatabase();

        String userId = et_userId.toString();
        String firstname = et_Name.getText().toString();
        String lastname = et_LastName.getText().toString();
        String id = et_Id.getText().toString();
        String phone = et_Phone.getText().toString();
        String email = et_Email.getText().toString();
        String address = et_Address.getText().toString();

        if(!userId.isEmpty() && !firstname.isEmpty() && !lastname.isEmpty() && !id.isEmpty() && !phone.isEmpty() && !email.isEmpty() && !address.isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("userId", userId);
            registro.put("Name", firstname);
            registro.put("LastName", lastname);
            registro.put("Id", id);
            registro.put("Phone", phone);
            registro.put("Email", email);
            registro.put("Address", address);

            BaseDeDatos.insert("usuarios", null, registro);

            BaseDeDatos.close();
            et_Name.setText("");
            et_LastName.setText("");
            et_Id.setText("");
            et_Phone.setText("");
            et_Email.setText("");
            et_Address.setText("");

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}