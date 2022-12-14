package com.example.calculadorasergio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URISyntaxException;

public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        TextView puntuacion = (TextView) findViewById(R.id.puntuacionTV);
        SeekBar miControl = (SeekBar) findViewById(R.id.seekBar);
        Button enviarBtn = (Button) findViewById(R.id.btnEnviar);

        TextView correo = (TextView) findViewById(R.id.emailET);
        TextView asunto = (TextView) findViewById(R.id.asuntoET);
        TextView comentario = (TextView) findViewById(R.id.comentarioET);

        ImageView menuimg = (ImageView) findViewById(R.id.imageView3);
        registerForContextMenu(menuimg);

        miControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                puntuacion.setText(String.valueOf(miControl.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        enviarBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                    Intent intent = new Intent(Intent.ACTION_SEND);

                    String enviarcorreo = String.valueOf(correo.getText());
                    String enviarasunto = String.valueOf(asunto.getText());
                    String enviarmensaje = String.valueOf(comentario.getText()) + "\nPuntuaci??n: " + String.valueOf(puntuacion.getText());

                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{enviarcorreo});
                    intent.putExtra(Intent.EXTRA_SUBJECT, enviarasunto);
                    intent.putExtra(Intent.EXTRA_TEXT, enviarmensaje);

                    if(enviarcorreo.equals("") || enviarasunto.equals("") || puntuacion.getText().toString().equals("")){
                            Toast.makeText(Contacto.this, "Rellene los campos obligatorios", Toast.LENGTH_LONG).show();
                    }
                    else {
                        intent.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent, "Elija una aplicaci??n: "));
                    }

            }

        });
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item){

        switch (item.getItemId()) {
            case R.id.MnOp1:

                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
                break;

            case R.id.MnOp2_1:

                Intent intent2_1 = new Intent(getApplicationContext(), Calculadora.class);
                startActivity(intent2_1);
                break;

            case R.id.MnOp2_2:

                Intent intent2_2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web2.0calc.es/"));
                startActivity(intent2_2);
                break;


            case R.id.MnOp3_1:

                Intent intent3 = new Intent(getApplicationContext(), Contacto.class);
                startActivity(intent3);
                break;

            case R.id.MnOp3_2:
                Intent intent3_2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/intl/es/gmail/about/"));
                startActivity(intent3_2);
                break;

            default: return super.onOptionsItemSelected(item);

        }
        return true;

    }

        @Override
        protected void onRestart() {
            super.onRestart();
            Intent volver = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(volver);
    }
}