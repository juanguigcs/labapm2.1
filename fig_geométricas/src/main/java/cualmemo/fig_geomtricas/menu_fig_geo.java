package cualmemo.fig_geomtricas;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class menu_fig_geo extends AppCompatActivity {
    int stado=5;
     double altu, basee, lado, radi, area;

    EditText etAltu, etBase, etLado, etRadi, etArea;
    Button bcal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_fig_geo);
        etAltu = (EditText) findViewById(R.id.etaltu);
        etBase = (EditText) findViewById(R.id.etbase);
        etLado = (EditText) findViewById(R.id.etlado);
        etRadi = (EditText) findViewById(R.id.etradi);
        etArea = (EditText) findViewById(R.id.etarea);
        stado=5;
        bcal = (Button) findViewById(R.id.bcalc);


        bcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String SetAltu=etAltu.getText().toString();
                String SetBase= etBase.getText().toString();
                String SetLado=etLado.getText().toString();
                String SetRadi= etRadi.getText().toString();
                int stado2=stado;

                switch (stado2) {
                    case 1:
                        if (TextUtils.isEmpty(SetLado)) {
                            etArea.setText("");
                            Toast.makeText(getApplicationContext(),"Campos vacíos .-.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            lado = Double.parseDouble(etLado.getText().toString());
                            area = lado * lado;
                            etArea.setText("cuadrado " + Double.toString(area));
                        }
                        break;
                    case 2:
                        if (TextUtils.isEmpty(SetAltu)||TextUtils.isEmpty(SetLado)) {
                            etArea.setText("");
                            Toast.makeText(getApplicationContext(),"Campos vacíos .-.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            altu = Double.parseDouble(etAltu.getText().toString());
                            lado = Double.parseDouble(etLado.getText().toString());
                            area = altu * lado;
                            etArea.setText("rectángulo " + Double.toString(area));
                        }
                        break;
                    case 3:
                        if (TextUtils.isEmpty(SetAltu)||TextUtils.isEmpty(SetBase)) {
                            etArea.setText("");
                            Toast.makeText(getApplicationContext(),"Campos vacíos .-.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            basee = Double.parseDouble(etBase.getText().toString());
                            altu = Double.parseDouble(etAltu.getText().toString());
                            area = (basee * altu) / 2;
                            etArea.setText("triángulo " + Double.toString(area));
                         }
                        break;
                    case 4:
                        if (TextUtils.isEmpty(SetRadi)) {
                            etArea.setText("");
                            Toast.makeText(getApplicationContext(),"Campos vacíos .-.", Toast.LENGTH_SHORT).show();
                             }
                        else {
                            radi = Double.parseDouble(etRadi.getText().toString());
                            area = 2 * radi * radi * 3.1416;
                            etArea.setText("círculo " + Double.toString(area));

                        }
                        break;
                    case 5:
                        //etArea.setText("");
                        Toast.makeText(getApplicationContext(),"Todo está vacío .-.", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbcuad:
                if (checked){
                    stado=1;
                   //etArea.setText("1");
                    etAltu.setVisibility(View.INVISIBLE);
                    etRadi.setVisibility(View.INVISIBLE);
                    etBase.setVisibility(View.INVISIBLE);
                    etLado.setVisibility(View.VISIBLE);
                    }
                    break;
            case R.id.rbrect:
                if (checked){
                    stado =2;
                    etAltu.setVisibility(View.VISIBLE);
                    etRadi.setVisibility(View.INVISIBLE);
                    etBase.setVisibility(View.INVISIBLE);
                    etLado.setVisibility(View.VISIBLE);
                //etArea.setText("2");
                }
                    break;
            case R.id.rbtria:
                if (checked){
                    stado =3;
                    etAltu.setVisibility(View.VISIBLE);
                    etRadi.setVisibility(View.INVISIBLE);
                    etBase.setVisibility(View.VISIBLE);
                    etLado.setVisibility(View.INVISIBLE);
              //  etArea.setText("3");
                    }
                break;
            case R.id.rbcirc:
                if (checked){
                    stado =4;
                    etAltu.setVisibility(View.INVISIBLE);
                    etRadi.setVisibility(View.VISIBLE);
                    etBase.setVisibility(View.INVISIBLE);
                    etLado.setVisibility(View.INVISIBLE);
                //etArea.setText("4");
                    }
                break;
        }
    }



}


