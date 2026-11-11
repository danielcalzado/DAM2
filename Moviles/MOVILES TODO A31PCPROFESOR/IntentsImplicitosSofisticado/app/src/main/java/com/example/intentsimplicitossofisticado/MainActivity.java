package com.example.intentsimplicitossofisticado;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnWebInstituto;
    private Button btnLlamarTelefono;
    private Button btnMarcarTelefono;
    private Button btnMaps;
    private Button btnFoto;
    private Button btnMail;
    private Button btnContactos;
    private Button btnMapsBuscar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWebInstituto = (Button)findViewById(R.id.btnWebInstituto);
        btnLlamarTelefono = (Button)findViewById(R.id.btnLlamarTelefono);
        btnMarcarTelefono = (Button)findViewById(R.id.btnMarcarTelefono);
        btnMaps = (Button)findViewById(R.id.btnMaps);
        btnFoto = (Button)findViewById(R.id.btnFoto);
        btnMail = (Button)findViewById(R.id.btnMail);
        btnContactos = (Button)findViewById(R.id.btnContactos);
        btnMapsBuscar = (Button)findViewById(R.id.btnMapsBuscar);
    }

    public void verInstituto(View v){
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://site.educa.madrid.org/ies.alonsodeavellan.alcala/"));
        startActivity(intent);
    }

    public void mapaInstituto(View v){
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:40.490626, -3.342152"));
        startActivity(intent);
    }

    public void verContactos(View v){
        intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
        startActivity(intent);
    }

    public void buscarPlazaCervantes(View v){
        Toast.makeText(getApplicationContext(), "Plaza Cervantes de Alcalá de Henares", Toast.LENGTH_LONG).show();
        Uri gmmIntentUri = Uri.parse("geo:0,0?z=17&q=" + Uri.encode("Plaza Cervantes, Alcalá de Henares"));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);

    }

    public void buscarEdificioArcipreste(View v){
        Toast.makeText(getApplicationContext(), "Edificio Arcipreste de Hita", Toast.LENGTH_LONG).show();
        Uri gmmIntentUri = Uri.parse("https://plus.codes/8CGRFMQ4+VF");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void trazarRutaPlazaCervantes(View v){
        Toast.makeText(getApplicationContext(), "Cómo llegar a la plaza Cervantes", Toast.LENGTH_LONG).show();
        Uri gmmIntentUri = Uri.parse("google.navigation:q=40.482537,-3.364279");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void streetViewPlazaCervantes(View v){
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=40.482537,-3.364279&cbp=0,30,0,0,-15");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void llamarInstituto(View v){
        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:974243477"));
        startActivity(intent);

    }

    public void llamarTelefono(View v){
        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
        //lanzarIntentSeguro(intent);
        startActivity(intent);
    }

    public void hacerFoto(View v){
        // Al usar Intent implícito (ACTION_IMAGE_CAPTURE), la app delega la toma de la foto en la app de cámara externa.
        // NO requiere comprobar ni solicitar el permiso CAMERA en código si no se declara en el Manifiesto.
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //lanzarIntentSeguro(intent);
        startActivity(intent);
    }

    public void enviarMail(View v){
        intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Solo aplicaciones de correo electrónico
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"iessguhuesca@educa.aragon.es"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Reciclaje tecnologico");
        intent.putExtra(Intent.EXTRA_TEXT, "Información sobre el proyecto de Educacion 2015");
        
        try {
            startActivity(Intent.createChooser(intent, "Enviar email con..."));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No se encontró ninguna aplicación de correo electrónico", Toast.LENGTH_SHORT).show();
        }
    }
}
