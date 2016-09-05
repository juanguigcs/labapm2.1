package cualmemo.fig_geomtricas;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class menu_fig_geo extends AppCompatActivity {
    int stado;
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
        bcal = (Button) findViewById(R.id.bcalc);

        bcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                altu = Double.parseDouble(etAltu.getText().toString());
                basee = Double.parseDouble(etBase.getText().toString());
                lado = Double.parseDouble(etLado.getText().toString());
                radi = Double.parseDouble(etRadi.getText().toString());
                switch (stado) {
                    case 1:
                        area = lado * lado;
                        etArea.setText("cuadrado "+Double.toString(area));
                        break;
                    case 2:
                        area = altu * lado;
                        etArea.setText("rectángulo "+Double.toString(area));
                        break;
                    case 3:
                        area = (basee * altu)/2;
                        etArea.setText("triángulo "+Double.toString(area));
                        break;
                    case 4:
                        area = 2 *radi*radi*3.1416;
                        etArea.setText("círculo "+Double.toString(area));
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


