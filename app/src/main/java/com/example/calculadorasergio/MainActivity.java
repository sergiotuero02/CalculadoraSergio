package com.example.calculadorasergio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView miTexto = (TextView) findViewById(R.id.nombreTV);
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animation1);
            miTexto.startAnimation(animacion);

        ImageView menuimg = (ImageView) findViewById(R.id.imageView4);
        registerForContextMenu(menuimg);

        ImageButton buttonImg = (ImageButton) findViewById(R.id.imageButton3);
        buttonImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                Intent intent = new Intent(MainActivity.this, Calculadora.class);
                startActivity(intent);
            }
        });



        Button button = (Button) findViewById(R.id.contactBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                Intent intent = new Intent(MainActivity.this, Contacto.class);
                startActivity(intent);
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
}